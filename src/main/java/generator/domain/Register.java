package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 挂号
 * @TableName register
 */
@TableName(value ="register")
@Data
public class Register implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 关联患者id
     */
    private Long patientid;

    /**
     * 关联科室id
     */
    private Long deptid;

    /**
     * 挂号类型,0-平诊 1-急诊
     */
    private Integer type;

    /**
     * 就诊状态,0-未就诊 1-已就诊
     */
    private Integer status;

    /**
     * 挂号费
     */
    private Integer fee;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 更新时间
     */
    private LocalDateTime updatetime;

    /**
     * 是否删除
     */
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}