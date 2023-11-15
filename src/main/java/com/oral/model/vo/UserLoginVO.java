package com.oral.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginVO implements Serializable {
    /**
     * token
     */
    private String token;


    /**
     * role 权限 admin/doctor
     */
    private String role;
}
