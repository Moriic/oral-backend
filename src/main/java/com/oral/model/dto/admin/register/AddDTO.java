package com.oral.model.dto.admin.register;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddDTO implements Serializable {

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
    private String sscard;

    /**
     * 关联科室
     */
    private Long deptId;

    /**
     * 挂号类型,0-平诊 1-急诊
     */
    private Integer type;

    /**
     * 挂号费
     */
    private Integer fee;
}
