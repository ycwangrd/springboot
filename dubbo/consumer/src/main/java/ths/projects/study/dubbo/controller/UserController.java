package ths.projects.study.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ths.projects.study.dubbo.model.UserModel;
import ths.projects.study.dubbo.service.UserService;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年09月28日 17:11:35
 * @Desc:
 */
@RestController(value = "/user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping(value = "/getUser")
    public UserModel getUser(int id) {
        return userService.getUser(id);
    }

    @GetMapping(value = "/list")
    public List<UserModel> list() {
        return userService.list();
    }
}
