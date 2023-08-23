package com.example.boot3.users.Entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("登录实体类")
public class LoginUNAndPDTO implements Serializable {
    private  String username;
    private  String password;
}
