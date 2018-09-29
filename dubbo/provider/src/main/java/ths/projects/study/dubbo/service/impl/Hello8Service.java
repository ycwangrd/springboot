package ths.projects.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import ths.projects.study.dubbo.service.HelloService;

import java.time.LocalDateTime;

/**
 * @author: wangrd
 * @since: 2018年09月29日 14:45:01
 * @Desc:
 */
@Service(version = "1.0.1")
public class Hello8Service implements HelloService {
    @Override
    public String sayHello(String hello) {
        return "Welcome to dubbo. Now is " + LocalDateTime.now();
    }
}
