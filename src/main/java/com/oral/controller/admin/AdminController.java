package com.oral.controller.admin;

import com.oral.common.BaseResponse;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.model.dto.admin.doctor.AddDTO;
import com.oral.model.dto.admin.doctor.DoctorPageDTO;
import com.oral.model.dto.admin.doctor.EditDTO;
import com.oral.model.entity.User;
import com.oral.model.vo.DoctorVO;
import com.oral.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/doctor", method = RequestMethod.POST)
    public BaseResponse<Boolean> add(@RequestBody AddDTO dto){
        adminService.add(dto);
        return ResultUtils.success(true);
    }

    @RequestMapping(value = "/doctor",method = RequestMethod.PUT)
    public BaseResponse<Boolean> edit(@RequestBody EditDTO dto){
        adminService.edit(dto);
        return ResultUtils.success(true);
    }

    @RequestMapping(value = "/doctor",method = RequestMethod.DELETE)
    public BaseResponse<Boolean> delete(String id) {
        adminService.delete(id);

        return ResultUtils.success(true);
    }

    @RequestMapping(value = "/doctor/{id}",method = RequestMethod.GET)
    public BaseResponse<DoctorVO> search(@PathVariable("id") String id) {
        DoctorVO result = new DoctorVO();

        User doctor = adminService.search(id);
        BeanUtils.copyProperties(doctor,result);

        return ResultUtils.success(result);
    }

    @RequestMapping(value = "/doctor/page",method = RequestMethod.GET)
    public BaseResponse<PageResult<DoctorVO>> search(DoctorPageDTO dto) {
        PageResult<User> users = adminService.search(dto);

        //copy
        PageResult<DoctorVO> result = new PageResult<>();
        result.setTotal(users.getTotal());
        result.setRecords(new ArrayList<>());
        for (User user : users.getRecords()) {
            DoctorVO patientVO = new DoctorVO();
            BeanUtils.copyProperties(user, patientVO);
            result.getRecords().add(patientVO);
        }

        return ResultUtils.success(result);
    }

}
