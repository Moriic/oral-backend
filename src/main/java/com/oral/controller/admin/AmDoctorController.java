package com.oral.controller.admin;

import com.oral.common.BaseResponse;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.model.dto.admin.doctor.AddDTO;
import com.oral.model.dto.admin.doctor.DoctorPageDTO;
import com.oral.model.dto.admin.doctor.EditDTO;
import com.oral.model.entity.Department;
import com.oral.model.entity.Doctor;
import com.oral.model.vo.DoctorVO;
import com.oral.service.AdminService;
import com.oral.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AmDoctorController {

    @Resource
    private AdminService adminService;
    @Resource
    private DepartmentService departmentService;

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
        DoctorVO doctorVO = new DoctorVO();

        Doctor doctor = adminService.search(id);
        BeanUtils.copyProperties(doctor,doctorVO);

        Department department = departmentService.query().eq("id", doctor.getDeptId()).one();
        doctorVO.setDepartment(department.getDept());

        return ResultUtils.success(doctorVO);
    }

    @RequestMapping(value = "/doctor/page",method = RequestMethod.GET)
    public BaseResponse<PageResult<DoctorVO>> search(DoctorPageDTO dto) {
        PageResult<Doctor> doctors = adminService.search(dto);

        //copy
        PageResult<DoctorVO> result = new PageResult<>();
        result.setTotal(doctors.getTotal());
        result.setRecords(new ArrayList<>());
        for (Doctor doctor : doctors.getRecords()) {
            DoctorVO doctorVO = new DoctorVO();
            BeanUtils.copyProperties(doctor, doctorVO);

            Department department = departmentService.query().eq("id", doctor.getDeptId()).one();
            doctorVO.setDepartment(department.getDept());

            result.getRecords().add(doctorVO);
        }

        return ResultUtils.success(result);
    }

}
