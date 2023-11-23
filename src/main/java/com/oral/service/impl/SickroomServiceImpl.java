package com.oral.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.common.ErrorCode;
import com.oral.common.PageResult;
import com.oral.exception.BusinessException;
import com.oral.mapper.SickroomMapper;
import com.oral.model.dto.admin.SickroomPageDTO;
import com.oral.model.entity.Sickbed;
import com.oral.model.entity.Sickroom;
import com.oral.service.SickroomService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【sickroom(病房)】的数据库操作Service实现
* @createDate 2023-11-15 17:15:26
*/
@Service
public class SickroomServiceImpl extends ServiceImpl<SickroomMapper, Sickroom>
    implements SickroomService{
    @Override
    public PageResult<Sickroom> search(SickroomPageDTO dto){
        Page<Sickroom> page = query()
                .eq("deptId",dto.getDeptId())
                .page(new Page<>(dto.getPage(), dto.getPageSize()));


        return new PageResult<>(page.getTotal(), page.getRecords());
    }
}




