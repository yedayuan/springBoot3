package com.example.boot3.users.Configurations;

import com.example.boot3.users.Interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//注册拦截器配置类
public class webconfig implements WebMvcConfigurer {
    @Autowired
  private   LoginCheckInterceptor loginCheckInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**");
    }

    @Bean
    public Docket docket(){
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("叶大源外卖平台")
                .version("2.0")
                .description("叶大源外卖平台接口文档")
                .build();

        Docket docket =new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                //指定扫描包
                .apis(RequestHandlerSelectors.basePackage("com.example.boot3.users.Controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
    //设置静态之源,主要是访问接口文档
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/doc.html")
                .addResourceLocations("classpath:/METH-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/METH-INF/resources/webjars/");
    }
}
