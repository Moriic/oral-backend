package com.oral.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.mapper.SurgeryMapper;
import com.oral.model.entity.Patient;
import com.oral.model.entity.Surgery;
import com.oral.model.vo.SurgeryVO;
import com.oral.service.PatientService;
import com.oral.service.SurgeryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @description 针对表【surgery(手术)】的数据库操作Service实现
 * @createDate 2023-10-17 23:27:36
 */
@Service
@Slf4j
public class SurgeryServiceImpl extends ServiceImpl<SurgeryMapper, Surgery>
        implements SurgeryService {

    @Resource
    SurgeryMapper surgeryMapper;
    @Resource
    PatientService patientService;

    /**
     * 根据id查询手术
     *
     * @param id
     * @return
     */
    public SurgeryVO getById(long id) {
        //根据id查询手术
        Surgery surgery = surgeryMapper.selectById(id);

        SurgeryVO surgeryVO = new SurgeryVO();
        //根据PatientId查询患者信息
        Patient patient = patientService.getById(surgery.getPatientId());
        //将患者信息封装到surgeryVO
        BeanUtils.copyProperties(surgery, surgeryVO);
        surgeryVO.setPatient(patient);
        return surgeryVO;
    }

}




