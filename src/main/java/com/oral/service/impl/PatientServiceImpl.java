package com.oral.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.common.ErrorCode;
import com.oral.common.PageResult;
import com.oral.exception.BusinessException;
import com.oral.mapper.PatientMapper;
import com.oral.model.dto.PatientPageDTO;
import com.oral.model.entity.Patient;
import com.oral.service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【patient(患者)】的数据库操作Service实现
* @createDate 2023-10-17 23:27:36
*/
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient>
    implements PatientService{

    @Override
    public Patient search(String id) {
        Patient patient = query().eq("id",id).one();
        if(patient == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"该患者不存在");
        }

        return patient;
    }

    @Override
    public PageResult<Patient> search(PatientPageDTO dto) {
        Page<Patient> page =  query().page(new Page<>(dto.getPage(),dto.getPageSize()));

        return new PageResult<>(page.getTotal(),page.getRecords());
    }
}




