package com.oral.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oral.model.entity.Doctor;
import com.oral.model.vo.DoctorVO;

/**
* @author Administrator
* @description 针对表【doctor(医生)】的数据库操作Service
* @createDate 2023-11-12 14:15:31
*/
public interface DoctorService extends IService<Doctor> {

    DoctorVO search();
}
