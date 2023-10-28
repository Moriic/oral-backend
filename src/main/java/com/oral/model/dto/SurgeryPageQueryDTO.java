package com.oral.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SurgeryPageQueryDTO implements Serializable {
    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页记录数
     */
    private Integer pageSize;
}
