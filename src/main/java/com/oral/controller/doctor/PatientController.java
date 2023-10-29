package com.oral.controller.doctor;

import com.oral.common.BaseResponse;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.model.dto.PatientPageDTO;
import com.oral.model.entity.Patient;
import com.oral.model.vo.PatientVO;
import com.oral.service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/doctor/patient")
public class PatientController {

    @Resource
    private PatientService patientService;

    @GetMapping("/{id}")
    public BaseResponse<PatientVO> search(@PathVariable("id") String id) {
        Patient patient = patientService.search(id);

        PatientVO vo = new PatientVO();
        BeanUtils.copyProperties(patient, vo);

        return ResultUtils.success(vo);
    }

    @GetMapping("page")
    public BaseResponse<PageResult<PatientVO>> search(PatientPageDTO patientPageDto) {
        PageResult<Patient> pageResult = patientService.search(patientPageDto);

        //copy
        PageResult<PatientVO> voPageResult = new PageResult<>();
        voPageResult.setTotal(pageResult.getTotal());
        voPageResult.setRecords(new ArrayList<>());
        for (Patient patient : pageResult.getRecords()) {
            PatientVO patientVO = new PatientVO();
            BeanUtils.copyProperties(patient, patientVO);
            voPageResult.getRecords().add(patientVO);
        }

        return ResultUtils.success(voPageResult);
    }
}
