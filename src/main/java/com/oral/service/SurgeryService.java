package com.oral.service;

import com.oral.common.PageResult;
import com.oral.model.dto.SurgeryPageQueryDTO;
import com.oral.model.entity.Surgery;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oral.model.vo.SurgeryVO;

/**
* @author Administrator
* @description 针对表【surgery(手术)】的数据库操作Service
* @createDate 2023-10-17 23:27:36
*/
public interface SurgeryService extends IService<Surgery> {
    /**
     * 根据id查询手术
     * @param id
     * @return
     */
    public SurgeryVO getById(long id);

}
