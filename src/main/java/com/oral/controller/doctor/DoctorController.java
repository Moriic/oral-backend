package com.oral.controller.doctor;


import com.oral.common.BaseResponse;
import com.oral.common.ErrorCode;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.exception.BusinessException;
import com.oral.exception.ThrowUtils;
import com.oral.model.dto.DoctorUpdateDTO;
import com.oral.model.dto.SurgeryPageQueryDTO;
import com.oral.model.entity.User;
import com.oral.model.vo.SurgeryVO;
import com.oral.service.SurgeryService;
import com.oral.service.UserService;
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
    private UserService userService;

    @Resource
    SurgeryService surgeryService;
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


    /**
     *根据id查询手术
     * @param id
     * @return
     */
    @GetMapping("/surgery/{id}")
    public BaseResponse<SurgeryVO> getById(@PathVariable long id){
        log.info("根据id查询手术：{}", id);
        SurgeryVO surgeryVO=surgeryService.getById(id);

        return ResultUtils.success(surgeryVO);
    }

    /**
     * 手术分页查询
     * @param surgeryPageQueryDTO
     * @return
     */
    @GetMapping("/surgery/page")
    public BaseResponse<PageResult<SurgeryVO>> pageQuery(@RequestBody SurgeryPageQueryDTO surgeryPageQueryDTO){
        log.info("手术分页查询:{}", surgeryPageQueryDTO);
        PageResult<SurgeryVO> pageResult=surgeryService.pageQuery(surgeryPageQueryDTO);

        return ResultUtils.success(pageResult);
    }

}
