package com.oral.model.vo;

import com.oral.model.entity.Patient;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserLogin implements Serializable {
    /**
     * token
     */
    private String token;


    /**
     * role 权限 admin/doctor
     */
    private String role;
}
