package com.oral.controller.doctor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oral.common.BaseResponse;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.model.dto.SurgeryPageQueryDTO;
import com.oral.model.entity.Patient;
import com.oral.model.entity.Surgery;
import com.oral.model.vo.SurgeryVO;
import com.oral.service.PatientService;
import com.oral.service.SurgeryService;
import com.oral.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor/surgery")
@Slf4j
public class SurgeryController {
    @Resource
    SurgeryService surgeryService;
    @Resource
    PatientService patientService;
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
        //PageResult<SurgeryVO> pageResult = surgeryService.pageQuery(surgeryPageQueryDTO);
        //构造分页构造器
        Page pageInfo = new Page(surgeryPageQueryDTO.getPage(),surgeryPageQueryDTO.getPageSize());

        //构造条件构造器
        LambdaQueryWrapper<Surgery> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.eq(Surgery::getDoctorId, BaseContext.getCurrentId());
        //执行查询
        surgeryService.page(pageInfo,queryWrapper);



        long total = pageInfo.getTotal();
        List<Surgery> records = pageInfo.getRecords();
        List<SurgeryVO> Recordes = new ArrayList<>();
        for (Surgery surgery : records) {
            SurgeryVO surgeryVO = new SurgeryVO();
            //根据PatientId查询患者信息
            Patient patient = patientService.getById(surgery.getPatientId());
            //将患者信息封装到surgeryVO
            BeanUtils.copyProperties(surgery, surgeryVO);
            surgeryVO.setPatient(patient);
            Recordes.add(surgeryVO);
        }

        PageResult<SurgeryVO>pageResult= new PageResult(total, Recordes);
        return ResultUtils.success(pageResult);
    }
}
