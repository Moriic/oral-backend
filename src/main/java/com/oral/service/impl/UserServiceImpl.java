package com.oral.service.impl;

import com.oral.common.ErrorCode;
import com.oral.constant.JwtClaimsConstant;
import com.oral.constant.UserConstant;
import com.oral.exception.BusinessException;
import com.oral.model.dto.UserLoginDTO;
import com.oral.model.entity.Admin;
import com.oral.model.entity.Doctor;
import com.oral.model.vo.UserLoginVO;
import com.oral.properties.JwtProperties;
import com.oral.service.AdminService;
import com.oral.service.DoctorService;
import com.oral.service.UserService;
import com.oral.utils.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 针对表【user(用户)】的数据库操作Service实现
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private DoctorService doctorService;
    @Resource
    private AdminService adminService;
    @Resource
    private JwtProperties jwtProperties;

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        // 获取用户信息
        String account = userLoginDTO.getAccount();
        String password = userLoginDTO.getPassword();
        // md5加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        // 先查询admin是否存在
        Admin admin = adminService.query().eq("account", account).one();
        if (admin != null && password.equals(admin.getPassword())) {
            //登录成功后，生成jwt令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put(JwtClaimsConstant.USER_ID, admin.getId());
            claims.put(JwtClaimsConstant.ROLE, UserConstant.ADMIN);

            String token = JwtUtil.createJWT(
                    jwtProperties.getUserSecretKey(),
                    jwtProperties.getUserTtl(),
                    claims);
            UserLoginVO userLoginVO = new UserLoginVO();
            // 返回jwt令牌
            userLoginVO.setToken(token);
            userLoginVO.setRole(UserConstant.ADMIN);
            return userLoginVO;
        }

        // 查询doctor
        Doctor doctor = doctorService.query().eq("account", account).one();
        // 用户不存在
        if (doctor == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在");
        }

        if (!password.equals(doctor.getPassword())) {
            //密码错误
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名或密码错误");
        }

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, doctor.getId());
        claims.put(JwtClaimsConstant.ROLE, UserConstant.DOCTOR);

        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);
        UserLoginVO userLoginVO = new UserLoginVO();
        // 返回jwt令牌
        userLoginVO.setToken(token);
        userLoginVO.setRole(UserConstant.DOCTOR);
        return userLoginVO;
    }
}




