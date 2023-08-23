package com.example.boot3;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class str {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql:///mybatisplus",
                        "root", "123456")
                .globalConfig(builder -> {
                    builder.author("叶大源") // 设置作者
                            // .enableSwagger() // 开启 swagger 模式
                            //  .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\idea1\\ewed\\stringboot3\\src\\main\\java"); // 指定输出目录
                })
                /* .packageConfig(builder -> builder.controller((globalConfig, typeRegistry, metaInfo) -> {
                     int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                     if (typeCode == Types.SMALLINT) {
                         // 自定义类型转换
                         return DbColumnType.INTEGER;  }  return typeRegistry.getColumnType(metaInfo);  }))*/
                .packageConfig(builder -> {

                    builder.parent("com.example.boot3") // 设置父包名
                            .moduleName("users") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    "D:\\idea1\\ewed\\stringboot3\\src\\main\\resources\\" +
                                            "com\\example\\boot3\\users\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user");// 设置需要生成的表名
                           // .addTablePrefix("web_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}

