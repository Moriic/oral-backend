package com.oral.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SickbedVO implements Serializable {
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 住院天数
     */
    private Long days;
    /**
     * id
     */
    private Long id;
    /**
     * 患者病情
     */
    private String illness;
    /**
     * 患者名称
     */
    private String patient;
    /**
     * 关联病房id
     */
    private Long roomId;
    /**
     * 状态 0-未启用 1-启用
     */
    private Long status;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
