package com.oral.model.dto.admin.register;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdatePatientDTO implements Serializable {
    /**
     * 患者id
     */
    private Long patientId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 血型
     */
    private String blood;

    /**
     * 社保卡号
     */
    private String ssCard;
}
