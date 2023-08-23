package com.example.boot3;

import com.example.boot3.users.Entity.User;
import com.example.boot3.users.Mapper.UserMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.*;

@SpringBootTest
class Stringboot3ApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test

    public void userremove() {
        List lists = new ArrayList();
        lists.add(12);
        lists.add(15);


    }

 /*   @Test
    public void dd() {
        new User()
                .setUsername("fdfd")
                .setName("fdfsdd")
                .setPassword("123456");
        //  userinsert.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        //  userinsert.setGender(userdto.getGender());
        //   userinsert.setAge(18);
        //    userinsert.setEmail("userdto@qq.com");
        //    userinsert.setEntrydate(LocalDate.now());
        //   userinsert.setBegindate(LocalDateTime.now());
        //   userinsert.setEnddate(userdto.getEnd());
        //   userinsert.setStatus(1);


        userMapper.userinsert(user);
    }*/

    @Test
    public void testgenJWT() {
        //生成jwts令牌,需要引入依赖 HS256-HS384-HS512-RS256
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "dayuan");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima")//签名算法
                .setClaims(map)//自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置时间1小时
                .compact();//已生成jwts令牌
        System.out.println(jwt);
    }

    @Test
    public void dds() {
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
    }
}

