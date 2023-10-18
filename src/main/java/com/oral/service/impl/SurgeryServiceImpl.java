package com.oral.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.model.entity.Surgery;
import com.oral.service.SurgeryService;
import com.oral.mapper.SurgeryMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【surgery(手术)】的数据库操作Service实现
* @createDate 2023-10-17 23:27:36
*/
@Service
public class SurgeryServiceImpl extends ServiceImpl<SurgeryMapper, Surgery>
    implements SurgeryService{

}




