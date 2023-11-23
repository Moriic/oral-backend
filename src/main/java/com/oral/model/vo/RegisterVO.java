package com.oral.model.vo;

import com.oral.model.entity.Patient;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class RegisterVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 关联患者
     */
    private Patient patient;

    /**
     * 关联科室
     */
    private String department           ;

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
    private LocalDateTime createtime;

    /**
     * 更新时间
     */
    private LocalDateTime updatetime;

}
