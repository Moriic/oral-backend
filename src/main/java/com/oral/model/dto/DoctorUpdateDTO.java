package com.oral.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DoctorUpdateDTO {

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
    private Date birthday;

    /**
     * 性别
     */
    private String gender;

    /**
     * 联系方式
     */
    private String phone;


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

}
