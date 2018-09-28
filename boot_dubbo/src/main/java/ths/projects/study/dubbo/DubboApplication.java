package ths.projects.study.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 王瑞东
 * @since 2018-09-27 10:24:10
 */
@SpringBootApplication
public class DubboApplication {

    public static void main(String[] args) {
        // start embedded zookeeper server
        new EmbeddedZooKeeper(2181, false).start();
        SpringApplication.run(DubboApplication.class, args);
    }

}
