package com.cwc.springbootInit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwc.springbootInit.model.entity.Patient;
import com.cwc.springbootInit.service.PatientService;
import com.cwc.springbootInit.mapper.PatientMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【patient(患者)】的数据库操作Service实现
* @createDate 2023-10-17 23:27:36
*/
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient>
    implements PatientService{

}




