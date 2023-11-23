package com.oral.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SickroomVO {
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * id
     */
    private Long id;
    /**
     * 护士
     */
    private String nurse;
    /**
     * 病房号
     */
    private Long roomNo;
    /**
     * 病床数
     */
    private Long roomNumber;
    /**
     * 0-普通病房，1-重症病房
     */
    private Long type;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
