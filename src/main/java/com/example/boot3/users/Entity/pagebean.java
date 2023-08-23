package com.example.boot3.users.Entity;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

//给前端返回结果列表
@Data
@ApiModel("分类分页查询返回")
public class pagebean {
    private long total;//总计录数常用
    private long current;//当前页面第几页常用
    private Integer size;//每页记录数
    private Integer pages;//总页数
    private String records;//分页数据

}
