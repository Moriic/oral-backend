package com.oral.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DoctorVO {
    /**
     * 账号
     */
    private String account;
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
    private Date birthday;
    /**
     * 创建时间
     */
    private Date createTime;
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
    /**
     * 用户角色：doctor/admin
     */
    private String role;
    /**
     * 更新时间
     */
    private Date updateTime;
}