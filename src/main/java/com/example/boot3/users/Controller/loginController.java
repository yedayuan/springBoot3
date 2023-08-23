package com.example.boot3.users.Controller;


import com.example.boot3.users.Entity.LoginUNAndPDTO;
import com.example.boot3.users.Entity.User;
import com.example.boot3.users.Results.Result;
import com.example.boot3.users.Service.IUserService;
import com.example.boot3.users.Utils.jwtutils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "登录接口")
@RequiredArgsConstructor
public class loginController {
    private final IUserService userService;

    //用户登陆功能
    @PostMapping("/login")
    @ApiOperation("登录入口")
    public Result<User> login(@RequestBody LoginUNAndPDTO loginUNAndPDTO) {
        User e = userService.login(loginUNAndPDTO);


        if (e != null) {
            Map<String, Object> Claims = new HashMap<>();
            Claims.put("id", e.getId());
            Claims.put("username", e.getUsername());

            String jwt = jwtutils.generateJWT(Claims);
            return Result.success(jwt);
        }
        return Result.error("用户或密码错误");
    }
    /*员工退出*/
    @PostMapping("/logout")
    public Result<User>  logout(HttpServletRequest request){
        //清理session中保存的登员工id
        request.getSession().removeAttribute("token");
        return Result.success("退出成功");
    }
}
