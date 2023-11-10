package com.oral.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.common.ErrorCode;
import com.oral.exception.BusinessException;
import com.oral.mapper.UserMapper;
import com.oral.model.dto.UserLoginDTO;
import com.oral.model.entity.User;
import com.oral.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * 针对表【user(用户)】的数据库操作Service实现
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        // 获取用户信息
        String account = userLoginDTO.getAccount();
        String password = userLoginDTO.getPassword();

        // 查询用户是否存在
        User user = query().eq("account", account).one();

        // 用户不存在
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在");
        }
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        if (!password.equals(user.getPassword())) {
            //密码错误
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名或密码错误");
        }
        return user;
    }


}




