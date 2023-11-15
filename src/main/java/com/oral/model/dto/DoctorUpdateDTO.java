package com.oral.model.dto;

import lombok.Data;

@Data
public class DoctorUpdateDTO {
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
