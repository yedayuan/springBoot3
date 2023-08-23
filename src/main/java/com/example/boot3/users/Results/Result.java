package com.example.boot3.users.Results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Result<T> {

    private Integer code;  //晌应码,1代表成功,0代表失败
    private String msg; //晌应信息,
    private T data;//返回结果



    public static <T> Result<T> success() {//增,删,改
        return new Result(200, "操作成功", null);

    }

    public static <T> Result<T> success(Object data) {//查
        return new Result(200, "操作成功", data);

    }

    public static <T> Result<T> error(String msg) { //操作失败

        return new Result(401, msg, null);
    }
    public static <T> Result<T> error(Integer code, String msg) { //操作失败

        return new Result(code, msg, null);
    }
    public static <T> Result<T> error() { //操作失败

        return new Result(501, "系统出现异常,请联系管理员", null);
    }
}
