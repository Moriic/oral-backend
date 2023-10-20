package com.oral.controller.common;


import com.oral.common.BaseResponse;
import com.oral.common.ResultUtils;
import com.oral.constant.JwtClaimsConstant;
import com.oral.model.dto.UserLoginDTO;
import com.oral.model.entity.User;
import com.oral.model.vo.UserLoginVO;
import com.oral.properties.JwtProperties;
import com.oral.service.UserService;
import com.oral.utils.BaseContext;
import com.oral.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private UserService userService;

    /**
     * 用户登录
     * @param userLoginDTO  账号密码
     * @return  返回账号信息和token
     */
    @PostMapping("/login")
    public BaseResponse<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        User user = userService.login(userLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        claims.put(JwtClaimsConstant.ROLE,user.getRole());

        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(user, userLoginVO);
        // 返回jwt令牌
        userLoginVO.setToken(token);
        return ResultUtils.success(userLoginVO);
    }

    /**
     * 退出登录
     *
     * @return true
     */
    @PostMapping("/logout")
    public BaseResponse<Boolean> userLogout() {
        return ResultUtils.success(true);
    }

    /**
     * 获取登录用户信息
     * @return 用户信息
     */
    @GetMapping
    public BaseResponse<UserLoginVO> getUserById(){
        Long userId = BaseContext.getCurrentId();
        User user = userService.getById(userId);

        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(user,userLoginVO);
        return ResultUtils.success(userLoginVO);
    }
}
