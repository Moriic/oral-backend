package com.oral.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oral.model.entity.Sickbed;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sickbed(床位)】的数据库操作Service
* @createDate 2023-11-15 17:15:26
*/
public interface SickbedService extends IService<Sickbed> {
    List<Sickbed> search(String id);

}
