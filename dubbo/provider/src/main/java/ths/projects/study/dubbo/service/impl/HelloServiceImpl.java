package ths.projects.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import ths.projects.study.dubbo.service.HelloService;

import java.util.Date;

/**
 * @author: wangrd
 * @since: 2018年09月28日 16:22:33
 * @Desc:
 */
@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}