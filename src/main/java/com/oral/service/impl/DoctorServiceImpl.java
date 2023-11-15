package com.oral.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.mapper.DepartmentMapper;
import com.oral.mapper.DoctorMapper;
import com.oral.model.entity.Department;
import com.oral.model.entity.Doctor;
import com.oral.model.vo.DoctorVO;
import com.oral.service.DoctorService;
import com.oral.utils.BaseContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @description 针对表【doctor(医生)】的数据库操作Service实现
 * @createDate 2023-11-12 14:15:31
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
        implements DoctorService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public DoctorVO search() {
        Long doctorId = BaseContext.getCurrentId();
        Doctor doctor = query().eq("id", doctorId).one();
        DoctorVO doctorVO = new DoctorVO();
        BeanUtils.copyProperties(doctor, doctorVO);

        Department department = departmentMapper.selectById(doctor.getDeptId());
        doctorVO.setDepartment(department.getDept());
        return doctorVO;
    }
}




