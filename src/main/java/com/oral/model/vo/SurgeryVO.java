package com.oral.model.vo;

import com.oral.model.entity.Patient;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SurgeryVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 患者id
     */
    private Long patientId;

    /**
     * 医生id
     */
    private Long doctorId;

    /**
     * 患者信息
     */
    private Patient patient;

    /**
     * 手术名称
     */
    private String name;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 手术时长
     */
    private Integer duration;

    /**
     * 医生工作(主刀)
     */
    private String job;

    /**
     * 既往病史
     */
    private String medicalHistory;

    /**
     * 慢性病史
     */
    private String chronicHistory;

    /**
     * 药物过敏
     */
    private String allergy;

    /**
     * 不良反应
     */
    private String reaction;

    /**
     * 术前评估,1-无风险 2-低风险 3-中风险 4-高风险
     */
    private Integer evaluation;

    /**
     * 术前检查,1-合格 2-不合格
     */
    private Integer examination;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
