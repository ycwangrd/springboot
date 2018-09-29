package ths.projects.study.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ths.projects.study.dubbo.service.HelloService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ConsumerApplication {

    @Reference(version = "1.0.0")
    private HelloService helloService;


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @PostConstruct
    public void init() {
        String sayHello = helloService.sayHello("world");
        System.err.println(sayHello);
    }

}
