package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 医生
 * @TableName doctor
 */
@TableName(value ="doctor")
@Data
public class Doctor implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 性别
     */
    private String gender;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 职称
     */
    private String job;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 照片
     */
    private String photo;

    /**
     * 简介
     */
    private String profile;

    /**
     * 关联科室id
     */
    private Long deptid;

    /**
     * 办公室
     */
    private String office;

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