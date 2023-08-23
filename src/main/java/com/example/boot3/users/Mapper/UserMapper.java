package com.example.boot3.users.Mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.boot3.users.Entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.boot3.users.Entity.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 叶大源
 * @since 2023-07-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //分页查询
    List<User> userselect(IPage<User> page, String name, Integer gender
            , LocalDateTime begin, LocalDateTime end
    );


    List<User> selectByIds(List <Integer> ids);


    void userinsert(User userinsert);

    void userdeleteById(List<Integer> ids);

    /*登陆功能查询用户密码*/
    @Select("select * from user where username=#{username}")
    User getname(String username);

    /*修改*/
    void userUpdate(User user);
}