package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 手术
 * @TableName surgery
 */
@TableName(value ="surgery")
@Data
public class Surgery implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 患者id
     */
    private Long patientid;

    /**
     * 医生id
     */
    private Long doctorid;

    /**
     * 手术名称
     */
    private String name;

    /**
     * 开始时间
     */
    private LocalDateTime starttime;

    /**
     * 手术时长
     */
    private Integer duration;

    /**
     * 医生工作(主刀)
     */
    private String job;

    /**
     * 既往病史
     */
    private String medicalhistory;

    /**
     * 慢性病史
     */
    private String chronichistory;

    /**
     * 药物过敏
     */
    private String allergy;

    /**
     * 不良反应
     */
    private String reaction;

    /**
     * 术前评估,1-无风险 2-低风险 3-中风险 4-高风险
     */
    private Integer evaluation;

    /**
     * 术前检查,1-合格 2-不合格
     */
    private Integer examination;

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