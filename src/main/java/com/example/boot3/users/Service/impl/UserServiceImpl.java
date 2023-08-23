package com.example.boot3.users.Service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.boot3.users.Entity.LoginUNAndPDTO;
import com.example.boot3.users.Entity.User;
import com.example.boot3.users.Entity.UserDTO;
import com.example.boot3.users.Entity.pagebean;
import com.example.boot3.users.Mapper.UserMapper;
import com.example.boot3.users.Service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 叶大源
 * @since 2023-07-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    //  current分页列表数,size每页记录数(默认),name名字, gender性别,age年龄,
    @Resource
    private UserMapper userMapper;

    /*分页查询*/
    @Override
    public List<User> userpage(Integer current
            , Integer size
            , String name
            , Integer gender
            , LocalDateTime begin
            , LocalDateTime end
    ) {
        IPage<User> page = new Page<>(current, size);
        List<User> userselects = userMapper.userselect(page, name, gender, begin, end);
        for (User userselect : userselects) {
            userselect.setPassword("******");
        }
        pagebean pagebean = new pagebean();
        pagebean.setTotal(page.getTotal());//总条数常用
        pagebean.setCurrent(page.getCurrent());//当前页面第几页常用
        return userselects;
    }

    //查询
    @Override
    public List<User> userselect(List<Integer> ids) {
        List<User> users = userMapper.selectByIds(ids);
        for (User user : users) {
            user.setPassword("******");
        }
        return users;
    }

    /*新增*/
    @Override
    public void usersave(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        user.setEntrydate(LocalDate.now());
        user.setBegindate(LocalDateTime.now());
        user.setStatus(0);
        //TODO
        user.setCreateid(10l);
        user.setUpdateid(10l);
        userMapper.userinsert(user);
    }

    /*删除*/
    @Override
    public void userremoveByIds(List<Integer> ids) {
        userMapper.userdeleteById(ids);
    }

    /*用户登陆功能*/
    @Override
    public User login(@RequestBody LoginUNAndPDTO loginUNAndPDTO) {


        String username = loginUNAndPDTO.getUsername();
        String password = loginUNAndPDTO.getPassword();


        User users = userMapper.getname(username);
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        /*if (username == null) {
            return null;//"用户不正确,抛出异常";

        }*/
        if (!username.equals(users.getUsername())) {

            return null;//"用户不正确,抛出异常";
        }
        if (!password.equals(users.getPassword())) {
            return null;//"密码不正确,抛出异常";
        }

        return users;
    }


    /*修改*/
    @Override
    public void userupdate(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setName(userDTO.getName());
        user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        user.setEntrydate(LocalDate.now());
        user.setBegindate(LocalDateTime.now());
        user.setStatus(0);

        //TODO
        userMapper.userUpdate(user);
    }
}
