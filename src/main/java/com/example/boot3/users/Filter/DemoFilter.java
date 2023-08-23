package com.example.boot3.users.Filter;


import com.alibaba.fastjson.JSONObject;
import com.example.boot3.users.Results.Result;
import com.example.boot3.users.Utils.jwtutils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * 3. 连接过滤器接口  implements Filter  重写doFilter分法
 * 2.分法上加 @WebFilter(urlPatterns = "/*")  过滤所有
 * 1. 启动类加 @ServletComponentScan
 */
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter { //jakarta.servlet倒包下
    /*自定义过滤器*/
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //1.获取请求uri
        String uri = req.getRequestURI().toString();
//2.判断请求uri是否包含login,如果包含分,说明是登录操作,放行
        if (uri.contains("login")) {
            chain.doFilter(request, response);//放行
        return;
        }
        //获得请求头中的令牌(token)
        String jwt = req.getHeader("token");
//判断jwt令牌是否存在,如果不存在,返回错误信息stringUtils (org.stringFramework.util包)
        if (!StringUtils.hasLength(jwt)) {
            Result<Object> error = Result.error("NOT_LOGIN未登录");
            //手动对象转换json,添加fastJSON依赖工具com.alibaba.fastjson包下
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return;
        }
        //解析token,如果解析失败,返回错误结果(未登录)
        try {
            jwtutils.parseJWT(jwt);
        } catch (Exception e) {//jwt解析失败
           e.printStackTrace();

            Result<Object> error = Result.error("NOT_LOGIN未登录");
            //手动对象转换json,添加fastJSON依赖工具com.alibaba.fastjson包下
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return;
        }
        chain.doFilter(request, response);//放行
    }


}
