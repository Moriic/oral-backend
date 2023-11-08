package com.oral.controller.admin;

import com.oral.common.BaseResponse;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.model.dto.PatientPageDTO;
import com.oral.model.dto.admin.doctor.AddDTO;
import com.oral.model.dto.admin.doctor.EditDTO;
import com.oral.model.vo.DoctorVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class DoctorController {

    @RequestMapping(value = "/doctor", method = RequestMethod.POST)
    public BaseResponse<Boolean> add(AddDTO dto){

        return ResultUtils.success(true);
    }

    @RequestMapping(value = "/doctor",method = RequestMethod.PUT)
    public BaseResponse<Boolean> edit(EditDTO dto){

        return ResultUtils.success(true);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public BaseResponse<Boolean> delete(@PathVariable("id") String id) {


        return ResultUtils.success(true);
    }

    @RequestMapping(value = "/doctor/{id}",method = RequestMethod.GET)
    public BaseResponse<Boolean> search(@PathVariable("id") String id) {


        return ResultUtils.success(true);
    }

    @RequestMapping(value = "/doctor/page",method = RequestMethod.GET)
    public BaseResponse<PageResult<DoctorVO>> search(PatientPageDTO patientPageDto) {
        //copy
        PageResult<DoctorVO> result = new PageResult<>();

        return ResultUtils.success(result);
    }

}
