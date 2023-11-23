package com.oral.model.dto.admin;

import com.oral.common.PageRequest;
import lombok.Data;

@Data
public class SickroomPageDTO extends PageRequest {
    private Integer deptId;
}
