package com.example.boot3.users.Service;

import com.example.boot3.users.Entity.LoginUNAndPDTO;
import com.example.boot3.users.Entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.boot3.users.Entity.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 叶大源
 * @since 2023-07-18
 */
public interface IUserService extends IService<User> {

    List<User> userpage(Integer current, Integer size, String name
            , Integer gender
            , LocalDateTime begin,
                        LocalDateTime end
    );

    List<User> userselect(List<Integer> ids);
    /*新增*/

    void usersave(UserDTO userDTO);

    void userremoveByIds(List<Integer> ids);

    /*用户登陆功能*/
    User login(LoginUNAndPDTO loginUNAndPDTO);

    /*修改用户*/
    void userupdate(UserDTO userDTO);
}
