package com.oral.mapper;

import com.github.pagehelper.Page;
import com.oral.model.entity.Surgery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
* @author Administrator
* @description 针对表【surgery(手术)】的数据库操作Mapper
* @createDate 2023-10-17 23:27:36
* @Entity com.oral.model.entity.Surgery
*/
public interface SurgeryMapper extends BaseMapper<Surgery> {
    /**
     * 根据id查询手术
     * @param id
     * @return
     */
    @Select("select * from surgery where id = #{id}")
    Surgery getById(long id);

    /**
     * 手术分页查询
     * @param id
     * @return
     */
    @Select("select * from surgery where doctorId = #{id}")
    Page<Surgery> pageQuery(long id);
}




