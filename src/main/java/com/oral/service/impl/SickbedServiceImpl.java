package com.oral.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.common.ErrorCode;
import com.oral.exception.BusinessException;
import com.oral.mapper.SickbedMapper;
import com.oral.model.entity.Sickbed;
import com.oral.service.SickbedService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sickbed(床位)】的数据库操作Service实现
* @createDate 2023-11-15 17:15:26
*/
@Service
public class SickbedServiceImpl extends ServiceImpl<SickbedMapper, Sickbed>
    implements SickbedService{

    @Override
    public List<Sickbed> search(String id){
        List<Sickbed> sickbeds = query().eq("id", id).list();
        if(sickbeds == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"该病房不存在");
        }

        return sickbeds;
    }
}




