package ths.projects.study.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ths.projects.study.dubbo.service.HelloService;

/**
 * @author: wangrd
 * @since: 2018年09月28日 16:29:24
 * @Desc:
 */
@RestController(value = "/hello")
public class HelloController {

    @Reference(version = "1.0.0")
    private HelloService helloService;

    @GetMapping(value = "/sayHello")
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
