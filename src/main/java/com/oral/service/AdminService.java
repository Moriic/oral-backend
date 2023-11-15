package com.oral.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oral.common.PageResult;
import com.oral.model.dto.admin.doctor.AddDTO;
import com.oral.model.dto.admin.doctor.DoctorPageDTO;
import com.oral.model.dto.admin.doctor.EditDTO;
import com.oral.model.entity.Admin;
import com.oral.model.entity.Doctor;

public interface AdminService extends IService<Admin> {
    void add(AddDTO dto);
    void edit(EditDTO dto);

    void delete(String id);

    Doctor search(String id);

    PageResult<Doctor> search(DoctorPageDTO dto);
}
