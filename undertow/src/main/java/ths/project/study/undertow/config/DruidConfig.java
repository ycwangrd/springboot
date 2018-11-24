package ths.project.study.undertow.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangrd
 * @since: 2018年11月17日 23:08:13
 * @Desc:
 */
@Configuration
public class DruidConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 创建DruidDataSource
     *
     * @return druid数据源
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druid() {
        logger.info("创建DruidDataSource");
        return new DruidDataSource();
    }

    // 配置Druid的监控
    // 在application.yml文件中配置好,自动创建
//    /**
//     * 1、配置一个管理后台的Servlet
//     *
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        Map<String, String> initParams = new HashMap<>(5);
//        initParams.put("loginUsername", "admin");
//        initParams.put("loginPassword", "123456");
//        // 默认就是允许所有访问
//        initParams.put("allow", "");
//        initParams.put("deny", "192.168.2.11");
//        bean.setInitParameters(initParams);
//        return bean;
//    }
//
//    /**
//     * 2、配置一个web监控的filter
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean webStatFilter() {
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.setFilter(new WebStatFilter());
//        Map<String, String> initParams = new HashMap<>();
//        initParams.put("exclusions", "*.js,*.css,/druid/*");
//        bean.setInitParameters(initParams);
//        bean.setUrlPatterns(Arrays.asList("/*"));
//        return bean;
//    }
}
