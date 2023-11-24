package com.oral.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oral.common.BaseResponse;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.model.dto.admin.register.AddDTO;
import com.oral.model.dto.admin.register.RegisterPageDTO;
import com.oral.model.dto.admin.register.UpdatePatientDTO;
import com.oral.model.entity.Register;
import com.oral.model.vo.RegisterVO;
import com.oral.service.PatientService;
import com.oral.service.RegisterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class RegisterController {
    @Resource
    RegisterService registerService;
    @Resource
    PatientService patientService;

    /**
     * 添加挂号
     *
     * @param addDTO
     * @return
     */
    @PostMapping("/register")
    public BaseResponse<Boolean> AddRegister(@RequestBody AddDTO addDTO) {
        registerService.Add(addDTO);
        return ResultUtils.success(true);
    }

    /**
     * 修改患者信息
     *
     * @param updatePatientDTO
     * @return
     */
    @PutMapping("/patient")
    public BaseResponse<Boolean> UpdatePatient(@RequestBody UpdatePatientDTO updatePatientDTO) {
        patientService.UpdatePatient(updatePatientDTO);
        return ResultUtils.success(true);
    }

    /**
     * 删除挂号
     *
     * @param id
     * @return
     */
    @DeleteMapping("/register")
    public BaseResponse<Boolean> DeleteRegister(String id) {
        registerService.removeById(id);
        return ResultUtils.success(true);
    }

    /**
     * 根据id查询挂号信息
     *
     * @param id
     * @return
     */
    @GetMapping("/register/{id}")
    public BaseResponse<RegisterVO> GetRegisterById(@PathVariable("id") String id) {
        RegisterVO registerVO = registerService.GetById(id);
        return ResultUtils.success(registerVO);
    }

    /**
     * 挂号分页查询
     *
     * @param registerPageDTO
     * @return
     */
    @GetMapping("/register/page")
    public BaseResponse<PageResult<RegisterVO>> pageQuery(RegisterPageDTO registerPageDTO) {
        Page pageInfo = new Page<>(registerPageDTO.getPage(), registerPageDTO.getPageSize());

        registerService.page(pageInfo);

        long total = pageInfo.getTotal();
        List<Register> records = pageInfo.getRecords();
        List<RegisterVO> Records = new ArrayList<>();
        for (Register register : records) {
            RegisterVO registerVO = registerService.GetById(String.valueOf(register.getId()));
            Records.add(registerVO);
        }
        PageResult<RegisterVO> pageResult = new PageResult(total, Records);
        return ResultUtils.success(pageResult);
    }

}
