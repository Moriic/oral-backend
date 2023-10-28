package com.oral.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PatientVO implements Serializable {
    //id
    private Long id;

    //姓名
    private String name;

    //性别
    private String gender;

    //年龄
    private Integer age;

    //联系方式
    private String phone;

    //血型
    private String blood;

    //社保卡号
    private String ssCard;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;
}
