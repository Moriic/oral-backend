package com.oral.controller.common;


import com.oral.common.BaseResponse;
import com.oral.common.ResultUtils;
import com.oral.constant.JwtClaimsConstant;
import com.oral.model.dto.UserLoginDTO;
import com.oral.model.vo.UserLoginVO;
import com.oral.properties.JwtProperties;
import com.oral.service.UserService;
import com.oral.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private JwtProperties jwtProperties;

    /**
     * 用户登录
     *
     * @param userLoginDTO 账号密码
     * @return 返回账号信息和token
     */
    @PostMapping("/login")
    public BaseResponse<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        return ResultUtils.success(userService.login(userLoginDTO));
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

    @GetMapping("/role")
    public BaseResponse<String> getRole(HttpServletRequest request) {
        String token = request.getHeader(jwtProperties.getUserTokenName());

        Claims claims = JwtUtil.parseJWT(jwtProperties.getUserSecretKey(), token);
        String role = claims.get(JwtClaimsConstant.ROLE).toString();
        return ResultUtils.success(role);
    }


}
