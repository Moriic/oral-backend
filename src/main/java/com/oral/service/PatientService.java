package com.oral.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oral.common.PageResult;
import com.oral.model.dto.PatientPageDTO;
import com.oral.model.dto.admin.regiser.UpdatePatientDTO;
import com.oral.model.entity.Patient;

/**
* @author Administrator
* @description 针对表【patient(患者)】的数据库操作Service
* @createDate 2023-10-17 23:27:36
*/
public interface PatientService extends IService<Patient> {
    Patient search(String id);
    PageResult<Patient> search(PatientPageDTO dto);

    /**
     * 修改患者信息
     * @param updatePatientDTO
     */
    void UpdatePatient(UpdatePatientDTO updatePatientDTO);
}
