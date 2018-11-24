package ths.project.study.undertow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author wangrd
 * @date 2018-11-17 23:38:15
 * @desc undertow启动类
 */
@SpringBootApplication
@EnableCaching
public class UndertowApplication {

    public static void main(String[] args) {
        SpringApplication.run(UndertowApplication.class, args);
    }
}
