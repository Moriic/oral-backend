package com.oral.controller.admin;

import com.oral.common.BaseResponse;
import com.oral.common.ResultUtils;
import com.oral.model.entity.Department;
import com.oral.model.vo.DepartmentVO;
import com.oral.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @GetMapping("/department")
    public BaseResponse<List<DepartmentVO>> login() {
        List<Department> departments = departmentService.query().list();

        List<DepartmentVO> result = new ArrayList<>();
        for (Department i : departments) {
            DepartmentVO vo = new DepartmentVO();
            BeanUtils.copyProperties(i, vo);

            result.add(vo);
        }

        return ResultUtils.success(result);
    }

}
