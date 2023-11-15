package com.oral.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.mapper.RegisterMapper;
import com.oral.model.entity.Register;
import com.oral.service.RegisterService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【register(挂号)】的数据库操作Service实现
* @createDate 2023-11-15 17:15:26
*/
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register>
    implements RegisterService{

}




