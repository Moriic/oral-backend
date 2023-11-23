package com.oral.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oral.common.PageResult;
import com.oral.model.dto.admin.SickroomPageDTO;
import com.oral.model.entity.Sickbed;
import com.oral.model.entity.Sickroom;

/**
* @author Administrator
* @description 针对表【sickroom(病房)】的数据库操作Service
* @createDate 2023-11-15 17:15:26
*/
public interface SickroomService extends IService<Sickroom> {

    PageResult<Sickroom> search(SickroomPageDTO dto);
}
