package com.oral.controller.common;


import com.oral.common.BaseResponse;
import com.oral.common.ResultUtils;
import com.oral.model.dto.UserLoginDTO;
import com.oral.model.vo.UserLoginVO;
import com.oral.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping
public class UserController {
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
