package com.oral.controller.admin;

import com.oral.common.BaseResponse;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.model.dto.admin.SickroomPageDTO;
import com.oral.model.entity.Sickbed;
import com.oral.model.entity.Sickroom;
import com.oral.model.vo.SickbedVO;
import com.oral.model.vo.SickroomVO;
import com.oral.service.SickbedService;
import com.oral.service.SickroomService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AdminICUController {

    @Resource
    private SickroomService sickroomService;
    @Resource
    private SickbedService sickbedService;

    @RequestMapping(value = "/sickroom/{id}",method = RequestMethod.GET)
    public BaseResponse<SickbedVO> search(@PathVariable("id") String id) {
        SickbedVO result = new SickbedVO();

        Sickbed target = sickbedService.search(id);
        BeanUtils.copyProperties(target,result);

        return ResultUtils.success(result);
    }

    @RequestMapping(value = "/sickroom",method = RequestMethod.GET)
    public BaseResponse<PageResult<SickroomVO>> search(@RequestBody SickroomPageDTO dto) {
        PageResult<Sickroom> page = sickroomService.search(dto);

        //copy
        PageResult<SickroomVO> result = new PageResult<>();
        result.setTotal(page.getTotal());
        result.setRecords(new ArrayList<>());
        for (Sickroom i : page.getRecords()) {
            SickroomVO vo = new SickroomVO();
            BeanUtils.copyProperties(i, vo);

            result.getRecords().add(vo);
        }

        return ResultUtils.success(result);
    }
}
