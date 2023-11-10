package com.oral.model.dto.admin.doctor;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class AddDTO {
    private String name;
    private Integer age;
    private String gender;
    private String phone;
    private String department;
    private String job;
    private String office;
    private String avatar;
    private String profile;
    private String role;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;
}

