package ths.project.study.undertow.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangrd
 * @since: 2018年11月18日 18:10:14
 * @Desc:
 */
@RestController
public class DruidStatController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/druid1/stat")
    public Object druidStat() {
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}
