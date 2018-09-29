package ths.projects.study.boot.springboot_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ths.projects.study.boot.springboot_mybatis.model.User;
import ths.projects.study.boot.springboot_mybatis.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@MapperScan("ths.projects.study.boot.springboot_mybatis.dao")
public class SpringbootMybatisApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    //@PostConstruct
    public void initUsers() {
        final int total = 5000;
        userService.clear();
        for (int i = 0; i < total; i++) {
            String name = "Name" + new Random().nextInt(total);
            String password = UUID.randomUUID().toString();
            User user = new User(name, password, getPhone());
            userService.addUser(user);
        }
        List<User> userList = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            String name = "Name1000" + new Random().nextInt(total);
            String password = UUID.randomUUID().toString();
            userList.add(new User(name, password, getPhone()));
        }
        userService.batchInsert("ths.projects.study.boot.springboot_mybatis.dao.UserDao.insert", userList);
    }

    /**
     * 返回手机号码
     */
    private String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    private String getPhone() {
        int index = getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    private int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }
}
