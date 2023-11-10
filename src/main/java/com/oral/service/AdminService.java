package com.oral.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oral.common.PageResult;
import com.oral.model.dto.admin.doctor.AddDTO;
import com.oral.model.dto.admin.doctor.DoctorPageDTO;
import com.oral.model.dto.admin.doctor.EditDTO;
import com.oral.model.entity.User;

public interface AdminService extends IService<User> {
    void add(AddDTO dto);
    void edit(EditDTO dto);

    void delete(String id);

    User search(String id);
    PageResult<User> search(DoctorPageDTO dto);
}
