package com.oral.model.vo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DoctorVO {
    /**
     * id
     */
    private long id;
    /**
     * 账号
     */
    private String account;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private long age;
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
     * 职称
     */
    private String job;

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
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}