package com.oral.service;

import com.oral.model.dto.UserLoginDTO;
import com.oral.model.vo.UserLoginVO;

public interface UserService {

    UserLoginVO login(UserLoginDTO userLoginDTO);
}
