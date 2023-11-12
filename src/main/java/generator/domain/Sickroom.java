package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 病房
 * @TableName sickroom
 */
@TableName(value ="sickroom")
@Data
public class Sickroom implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 病房号
     */
    private Integer roomno;

    /**
     * 关联所属科室id
     */
    private Long deptid;

    /**
     * 0-普通病房，1-重症病房
     */
    private Integer type;

    /**
     * 病床数
     */
    private Integer roomnumber;

    /**
     * 护士
     */
    private String nurse;

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