package ths.projects.study.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ths.projects.study.dubbo.model.UserModel;
import ths.projects.study.dubbo.reponsotory.UserReponsitory;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * @author wangrd
 */
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        // start embedded zookeeper server
        new EmbeddedZooKeeper(2181, false).start();
        SpringApplication.run(ProviderApplication.class, args);
    }

    @PostConstruct
    public void initUsers() {
        for (int i = 0; i < 100; i++) {
            UserReponsitory.userMap.put(i, new UserModel(i + 1, "User" + i, new Random().nextInt(50)));
        }
    }

}
