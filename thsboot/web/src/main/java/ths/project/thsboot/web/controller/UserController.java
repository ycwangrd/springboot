package ths.project.thsboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ths.project.thsboot.model.User;
import ths.project.thsboot.persistence.service.UserService;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年07月21日 19:37:21
 * @Desc:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/list")
    public List<User> list(@RequestParam(value = "name", required = false) String name) {
        List<User> users = service.list(name);
        return users;
    }
}
