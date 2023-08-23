package com.example.boot3.users.Entity;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//前端传递过来数据
@ApiModel("前端传来的用户实体类")
public class UserDTO extends User{  

    private String username;/*姓名*/

    private String name;/*姓名*/

    private Integer gender;/*性别*/

    private LocalDateTime begin;//开始时间
    private LocalDateTime end;//结束时间

    private Integer current;//  current分页列表数
    private Integer size;//size每页记录数(默认2)

}
