package com.oral.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oral.model.dto.admin.register.AddDTO;
import com.oral.model.entity.Register;
import com.oral.model.vo.RegisterVO;

/**
* @author Administrator
* @description 针对表【register(挂号)】的数据库操作Service
* @createDate 2023-11-15 17:15:26
*/
public interface RegisterService extends IService<Register> {
    /**
     * 添加挂号
     * @param addDTO
     */
    void Add(AddDTO addDTO);


    /**
     * 根据id查询挂号信息
     * @param id
     * @return
     */
    RegisterVO GetById(String id);
}
