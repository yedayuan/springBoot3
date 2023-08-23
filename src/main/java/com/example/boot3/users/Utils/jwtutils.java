package com.example.boot3.users.Utils;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import java.util.Map;

public class jwtutils {

    //设置jwt加密使用的密钥(需要依赖)
    private static String signkey="itheima";
    //设置过期时间
    private static Long expire=432000l;
    //生成jwts令牌,需要引入依赖 HS256-HS384-HS512-RS256 工具类


    public static String generateJWT(Map<String,Object> claims){
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,signkey)//签名算法
                .setClaims(claims)//自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + expire ))//设置时间1小时
                .compact();//已生成jwts令牌
        return jwt;
    }
    //解析工具类jwts令牌
    public  static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()//
                .setSigningKey(signkey)
                .parseClaimsJws(jwt)//
                .getBody();
        return claims;
    }
}
