package com.oral.model.dto.admin.doctor;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddDTO {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 性别
     */
    private String gender;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 职称
     */
    private String job;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 照片
     */
    private String photo;

    /**
     * 简介
     */
    private String profile;

    /**
     * 关联科室id
     */
    private Long deptId;

    /**
     * 办公室
     */
    private String office;

}

