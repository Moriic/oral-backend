package com.oral.controller.doctor;


import com.oral.common.BaseResponse;
import com.oral.common.ErrorCode;
import com.oral.common.ResultUtils;
import com.oral.exception.BusinessException;
import com.oral.exception.ThrowUtils;
import com.oral.model.dto.DoctorUpdateDTO;
import com.oral.model.entity.User;
import com.oral.service.UserService;
import com.oral.utils.BaseContext;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Resource
    private UserService userService;

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
        User user = new User();
        BeanUtils.copyProperties(doctorUpdateDTO, user);
        Long userId = BaseContext.getCurrentId();
        user.setId(userId);
        boolean result = userService.updateById(user);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(true);
    }

}
