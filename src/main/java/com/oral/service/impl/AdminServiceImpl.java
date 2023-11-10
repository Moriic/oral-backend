package com.oral.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oral.common.ErrorCode;
import com.oral.common.PageResult;
import com.oral.common.ResultUtils;
import com.oral.exception.BusinessException;
import com.oral.mapper.UserMapper;
import com.oral.model.dto.admin.doctor.AddDTO;
import com.oral.model.dto.admin.doctor.DoctorPageDTO;
import com.oral.model.dto.admin.doctor.EditDTO;
import com.oral.model.entity.User;
import com.oral.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

@Service
public class AdminServiceImpl extends ServiceImpl<UserMapper, User> implements AdminService {
    @Override
    public void add(AddDTO dto) {
        User data = new User();
        BeanUtils.copyProperties(dto,data);
        //暂时以手机号为账号
        data.setAccount(data.getPhone());
        data.setPassword("123456");
        try {
            data.setBirthday(DateFormat.getDateInstance().parse(dto.getBirthday()));
        }catch (ParseException e){
            data.setBirthday(new Date());
        }

        super.save(data);
    }
    @Override
    public void edit(EditDTO dto){
        User data = search(String.valueOf(dto.getId()));
        BeanUtils.copyProperties(dto,data);
        super.saveOrUpdate(data);
    }

    @Override
    public void delete(String id){
        User data = search(id);
        data.setIsDelete(1);
        super.removeById(data);
    }

    @Override
    public User search(String id){
        User result = query().eq("id",id).one();
        if(result == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"该患者不存在");
        }

        return result;
    }

    @Override
    public  PageResult<User> search(DoctorPageDTO dto){
        Page<User> page =  query().page(new Page<>(dto.getPage(),dto.getPageSize()));

        return new PageResult<>(page.getTotal(),page.getRecords());
    }
}
