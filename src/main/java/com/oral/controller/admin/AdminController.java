package com.oral.controller.admin;


import com.oral.common.BaseResponse;
import com.oral.common.ResultUtils;
import com.oral.model.entity.Admin;
import com.oral.model.vo.AdminVO;
import com.oral.service.AdminService;
import com.oral.utils.BaseContext;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @GetMapping
    public BaseResponse<AdminVO> getById() {
        Admin admin = adminService.getById(BaseContext.getCurrentId());
        AdminVO adminVO = new AdminVO();
        BeanUtils.copyProperties(admin,adminVO);
        return ResultUtils.success(adminVO);
    }
}
