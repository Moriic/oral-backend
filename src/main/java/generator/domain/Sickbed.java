package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 床位
 * @TableName sickbed
 */
@TableName(value ="sickbed")
@Data
public class Sickbed implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 床号
     */
    private Integer bedno;

    /**
     * 关联病房id
     */
    private Long roomid;

    /**
     * 状态 0-未启用 1-启用
     */
    private Integer status;

    /**
     * 患者名称
     */
    private String patient;

    /**
     * 患者病情
     */
    private String illness;

    /**
     * 住院天数
     */
    private Integer days;

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