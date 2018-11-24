package ths.project.study.undertow.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ths.project.study.undertow.base.Paging;

import java.util.List;
import java.util.Map;

/**
 * @author: wangrd
 * @since: 2018年11月17日 22:58:35
 * @Desc:
 */
@Service
public class GirlService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final String sqlPackage = "ths.project.study.undertow.mapper.GirlMapper";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 查询所有数据,不分页
     *
     * @return
     */
    @Cacheable(value = "thscache")
    public List<Map<String, Object>> list() {
        List<Map<String, Object>> dataList = sqlSessionTemplate.selectList(sqlPackage + ".list");
        logger.info("所有用户:" + dataList);
        return dataList;
    }

    /**
     * 查询分页列表信息
     *
     * @param pageInfo
     * @return
     */
    @Cacheable(value = "thscache")
    public PageInfo<Map<String, Object>> pageList(PageInfo<Map<String, Object>> pageInfo) {
        if (pageInfo.getPageNum() == 0) {
            pageInfo.setPageNum(1);
        }
        if (pageInfo.getPageSize() == 0) {
            pageInfo.setPageSize(20);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Map<String, Object>> list = sqlSessionTemplate.selectList(sqlPackage + ".list");
        return new Paging<>(list, pageInfo.getNavigatePages());
    }
}
