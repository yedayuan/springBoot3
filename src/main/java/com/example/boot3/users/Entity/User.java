package com.example.boot3.users.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author 叶大源
 * @since 2023-07-18
 */


@Data
@TableName(value = "user")
@ApiModel("用户实体类")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;/*主键ID*/
    private String username; /**用户*/
    private String name;/*姓名*/
    private String password;/*密码*/

    private Integer gender;/*性别*/

    private Integer age; /*年龄*/


    private LocalDate entrydate;//入职时间

    private LocalDateTime begindate;//入职开始时间

    private LocalDateTime enddate;//入职结束时间
    private String email;/*邮箱*/
    private Integer status; /*状态0可用,1锁定*/
    /*创建人id*/

   private long createid;
    /*修改人id*/
   private long updateid;
}
