package com.oral.model.dto.admin.doctor;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EditDTO {
    /**
     * 年龄
     */
    private Long age;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 出生日期
     */
    private LocalDate birthday;
    /**
     * 科室
     */
    private String department;
    /**
     * 性别
     */
    private String gender;
    /**
     * id
     */
    private long id;
    /**
     * 职称
     */
    private String job;
    /**
     * 姓名
     */
    private String name;
    /**
     * 办公室
     */
    private String office;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 简介
     */
    private String profile;
}
