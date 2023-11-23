package com.oral.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.mapper.DepartmentMapper;
import com.oral.mapper.PatientMapper;
import com.oral.mapper.RegisterMapper;
import com.oral.model.dto.admin.register.AddDTO;
import com.oral.model.entity.Patient;
import com.oral.model.entity.Register;
import com.oral.model.vo.RegisterVO;
import com.oral.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Administrator
* @description 针对表【register(挂号)】的数据库操作Service实现
* @createDate 2023-11-15 17:15:26
*/
@Service
@Slf4j
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register>
    implements RegisterService{

    @Resource
    PatientMapper patientMapper;
    @Resource
    DepartmentMapper departmentMapper;
    /**
     * 添加挂号
     * @param addDTO
     */
    public void Add(AddDTO addDTO) {
        log.info("AddDO:{}",addDTO);

        Register register=new Register();
        //拷贝数据
        BeanUtils.copyProperties(addDTO,register);
        //挂号，未就诊
        register.setStatus(0);
        //设置科室ID
        register.setDeptId(addDTO.getDeptId());
        log.info("register:{}",register);


        //根据社保卡号查病人
        LambdaQueryWrapper<Patient> lq=new LambdaQueryWrapper();
        lq.eq(Patient::getSsCard,addDTO.getSscard());
        Patient patient = patientMapper.selectOne(lq);
        //设置病人ID
        register.setPatientId(patient.getId());
        super.save(register);
    }

    /**
     * 根据id查询挂号信息
     * @param id
     * @return
     */
    public RegisterVO GetById(String id) {
        Register register = super.getById(id);
        RegisterVO registerVO=new RegisterVO();
        //拷贝数据
        BeanUtils.copyProperties(register,registerVO);

        //获取科室
        String dept = departmentMapper.selectById(register.getDeptId()).getDept();
        //获取患者信息
        Patient patient = patientMapper.selectById(register.getPatientId());

        registerVO.setDepartment(dept);
        registerVO.setPatient(patient);
        return registerVO;
    }
}




