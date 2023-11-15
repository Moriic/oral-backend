package com.oral.controller.doctor;


import com.oral.common.BaseResponse;
import com.oral.common.ErrorCode;
import com.oral.common.ResultUtils;
import com.oral.exception.BusinessException;
import com.oral.exception.ThrowUtils;
import com.oral.model.dto.DoctorUpdateDTO;
import com.oral.model.entity.Doctor;
import com.oral.model.vo.DoctorVO;
import com.oral.service.DoctorService;
import com.oral.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor")
@Slf4j
public class DoctorController {
    @Resource
    private DoctorService doctorService;
    /**
     * 获取医生信息
     */
    @GetMapping
    public BaseResponse<DoctorVO> search(){
        DoctorVO doctorVO = doctorService.search();
        return ResultUtils.success(doctorVO);
    }

    /**
     * 医生更新个人信息
     * @param doctorUpdateDTO 更新信息
     * @return true/false
     */
    @PutMapping("/update")
    public BaseResponse<Boolean> updateDoctor(@RequestBody DoctorUpdateDTO doctorUpdateDTO) {
        if (doctorUpdateDTO == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(doctorUpdateDTO, doctor);
        Long doctorId = BaseContext.getCurrentId();
        doctor.setId(doctorId);
        boolean result = doctorService.updateById(doctor);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(true);
    }
}
