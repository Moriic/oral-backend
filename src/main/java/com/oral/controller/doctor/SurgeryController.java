package com.oral.controller.doctor;

import com.oral.common.BaseResponse;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.model.dto.SurgeryPageQueryDTO;
import com.oral.model.vo.SurgeryVO;
import com.oral.service.SurgeryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor/surgery")
@Slf4j
public class SurgeryController {
    @Resource
    SurgeryService surgeryService;

    /**
     * 根据id查询手术
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public BaseResponse<SurgeryVO> getById(@PathVariable long id) {
        log.info("根据id查询手术：{}", id);
        SurgeryVO surgeryVO = surgeryService.getById(id);

        return ResultUtils.success(surgeryVO);
    }

    /**
     * 手术分页查询
     *
     * @param surgeryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public BaseResponse<PageResult<SurgeryVO>> pageQuery(SurgeryPageQueryDTO surgeryPageQueryDTO) {
        log.info("手术分页查询:{}", surgeryPageQueryDTO);
        PageResult<SurgeryVO> pageResult = surgeryService.pageQuery(surgeryPageQueryDTO);

        return ResultUtils.success(pageResult);
    }
}
