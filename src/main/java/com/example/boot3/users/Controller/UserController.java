package com.example.boot3.users.Controller;


import com.example.boot3.users.Entity.User;
import com.example.boot3.users.Entity.UserDTO;
import com.example.boot3.users.Results.Result;
import com.example.boot3.users.Service.IUserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 叶大源
 * @since 2023-07-18
 */
@RestController
@RequestMapping("/users/user")
@ApiOperation("接口操作")
@Log4j2
@RequiredArgsConstructor
public class UserController {
    private  final IUserService userService;


    /*分页查询*/
    @ApiOperation("分页查询功能")
    @GetMapping("/paging")
    private Result<UserDTO> userselect(
            @RequestParam(defaultValue = "1") Integer current
            , @RequestParam(defaultValue = "2") Integer size
            , String name
            , Integer gender
            , @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime begin
            , @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime end
    ) {

        List<User> userlist = userService.userpage(current, size, name, gender, begin, end);
        return Result.success(userlist);
    }

    /*查询*/
    @ApiOperation("多查询ID")
    @GetMapping("/{ids}")
    private Result<User> userselect(@PathVariable List<Integer> ids) {
        List<User> lists = userService.userselect(ids);
        return Result.success(lists);
    }
/*新增*/
    @ApiOperation("新增用户功能")
    @PostMapping
    private Result<User> insert(@RequestBody UserDTO userDTO) {
        userService.usersave(userDTO);
        return Result.success();
    }

    /*删除*/
    @ApiOperation("ids删除功能")
    @DeleteMapping("/ids")
    private Result<User> delete(@RequestParam List<Integer> ids) {
        userService.userremoveByIds(ids);
        return Result.success();
    }

    /*修改用户*/
    @ApiOperation("userDTO修改用户功能")
    @PutMapping
    private Result<User> Update(@RequestBody UserDTO userDTO) {
        log.info("编制用户:{}", userDTO);
        userService.userupdate(userDTO);
        return Result.success();
    }
}
