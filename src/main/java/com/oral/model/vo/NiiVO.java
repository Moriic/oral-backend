package com.oral.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class NiiVO implements Serializable {
    // 生成uuid路径
    private String id;

    // 各切面数量
    private Integer x;
    private Integer y;
    private Integer z;
}
