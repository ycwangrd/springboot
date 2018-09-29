package ths.projects.study.boot.springboot_mybatis;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author: wangrd
 * @since: 2018年09月29日 17:38:54
 * @Desc: jsp的支持
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootMybatisApplication.class);
    }
}
