package ths.project.study.undertow.controller;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ths.project.study.undertow.service.GirlService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author: wangrd
 * @since: 2018年11月17日 22:54:22
 * @Desc:
 */
@RestController
public class GirlController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GirlService girlService;
    
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(name = "/girl/getAll")
    public List<Map<String, Object>> getAll() {
        logger.info("查询用户列表时间:" + LocalDateTime.now());
        List<Map<String, Object>> dataList = girlService.list();
        return dataList;
    }

    @RequestMapping(value = "/girl/list")
    public PageInfo<Map<String, Object>> list(PageInfo<Map<String, Object>> pageInfo) {
        pageInfo = girlService.pageList(pageInfo);
        logger.info("分页信息:" + pageInfo);
        return pageInfo;
    }
}
