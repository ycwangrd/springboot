package ths.project.thsboot.persistence.task;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ths.project.thsboot.model.Girl;
import ths.project.thsboot.persistence.service.GirlService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年07月30日 14:02:40
 * @Desc:
 */
@Component
public class QueryGirlsTask {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GirlService girlService;

    /**
     * 每 15分钟 执行一次
     */
    @Scheduled(cron = "0 0/15 * * * ?")
    public void printGirls() {
        List<Girl> girls = girlService.list();
        logger.info(LocalDateTime.now().toString() + new Gson().toJson(girls));
    }
}
