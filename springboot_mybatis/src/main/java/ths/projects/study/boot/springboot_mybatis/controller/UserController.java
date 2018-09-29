package ths.projects.study.boot.springboot_mybatis.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ths.projects.study.boot.springboot_mybatis.model.User;
import ths.projects.study.boot.springboot_mybatis.service.UserService;

/**
 * @author: wangrd
 * @since: 2018年09月29日 15:54:36
 * @Desc:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @PostMapping(value = "/add")
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping(value = "/list")
    public PageInfo<User> list(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return userService.list(pageNum, pageSize);
    }
}
