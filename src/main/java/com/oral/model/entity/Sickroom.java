package com.oral.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 病房
 * @TableName sickroom
 */
@TableName(value ="sickroom")
@Data
public class Sickroom implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 病房号
     */
    private Integer roomNo;

    /**
     * 关联所属科室id
     */
    private Long deptId;

    /**
     * 0-普通病房，1-重症病房
     */
    private Integer type;

    /**
     * 病床数
     */
    private Integer roomNumber;

    /**
     * 护士
     */
    private String nurse;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}