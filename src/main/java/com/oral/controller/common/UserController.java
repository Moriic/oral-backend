package com.oral.controller.common;


import com.oral.common.BaseResponse;
import com.oral.common.ResultUtils;
import com.oral.constant.JwtClaimsConstant;
import com.oral.model.dto.UserLoginDTO;
import com.oral.model.entity.User;
import com.oral.model.vo.UserLoginVO;
import com.oral.properties.JwtProperties;
import com.oral.service.UserService;
import com.oral.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping
public class LoginController {
    @Resource
    private UserService userService;

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
}
