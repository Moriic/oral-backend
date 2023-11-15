package com.oral.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.common.ErrorCode;
import com.oral.common.PageResult;
import com.oral.exception.BusinessException;
import com.oral.mapper.AdminMapper;
import com.oral.model.dto.admin.doctor.AddDTO;
import com.oral.model.dto.admin.doctor.DoctorPageDTO;
import com.oral.model.dto.admin.doctor.EditDTO;
import com.oral.model.entity.Admin;
import com.oral.model.entity.Doctor;
import com.oral.service.AdminService;
import com.oral.service.DoctorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    private DoctorService doctorService;

    @Override
    public void add(AddDTO dto) {
        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(dto, doctor);
        //暂时以手机号为账号
        doctor.setAccount(doctor.getPhone());
        doctor.setPassword(MD5.create().digestHex("123456"));
        doctorService.save(doctor);
    }

    @Override
    public void edit(EditDTO dto) {
        Doctor doctor = search(String.valueOf(dto.getId()));
        BeanUtils.copyProperties(dto, doctor);
        doctorService.saveOrUpdate(doctor);
    }

    @Override
    public void delete(String id) {
        doctorService.removeById(id);
    }

    @Override
    public Doctor search(String id) {
        Doctor doctor = doctorService.query().eq("id", id).one();
        if (doctor == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "该医生不存在");
        }
        return doctor;
    }

    @Override
    public PageResult<Doctor> search(DoctorPageDTO dto) {
        Page<Doctor> page = doctorService.query().page(new Page<>(dto.getPage(), dto.getPageSize()));

        return new PageResult<>(page.getTotal(), page.getRecords());
    }
}
