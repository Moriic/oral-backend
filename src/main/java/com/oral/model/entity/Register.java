package com.oral.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 挂号
 * @TableName register
 */
@TableName(value ="register")
@Data
public class Register implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 关联患者id
     */
    private Long patientId;

    /**
     * 关联科室id
     */
    private Long deptId;

    /**
     * 挂号类型,0-平诊 1-急诊
     */
    private Integer type;

    /**
     * 就诊状态,0-未就诊 1-已就诊
     */
    private Integer status;

    /**
     * 挂号费
     */
    private Integer fee;

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