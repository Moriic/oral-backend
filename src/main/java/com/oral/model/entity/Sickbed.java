package com.oral.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 床位
 * @TableName sickbed
 */
@TableName(value ="sickbed")
@Data
public class Sickbed implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 床号
     */
    private Integer bedNo;

    /**
     * 关联病房id
     */
    private Long roomId;

    /**
     * 状态 0-未启用 1-启用
     */
    private Integer status;

    /**
     * 患者名称
     */
    private String patient;

    /**
     * 患者病情
     */
    private String illness;

    /**
     * 住院天数
     */
    private Integer days;

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