package ths.project.thsboot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import ths.project.thsboot.model.Girl;
import ths.project.thsboot.persistence.repository.GirlRepository;

import java.util.Collection;

/**
 * @author: wangrd
 * @since: 2018年07月29日 17:48:56
 * @Desc: 路由器函数 配置
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     * 请求接口: ServletRequest 或者 HttpServletRequest
     * 响应接口: ServletResponse 或者 HttpServletResponse
     * <p>
     * Spring5.0 重新定义了服务请求和响应接口
     * 请求接口: ServerRequest
     * 响应接口:ServerResponse
     * 既可以支持Servlet规范,也可以支持自定义,比如:Netty (Web Server)
     * <p>
     * 以本地:
     * 定义GET请求,并且返回所有的用户对象 URL:/person/find/all
     * Flux 是 0 - N个对象集合
     * Mono 是 0 - 1个对象集合
     * Reactive 中的 Flux 或者 Mono是异步处理(非阻塞)
     * 集合对象基本是同步处理(阻塞)
     * <p>
     * Flux 或者 Mono 都是Publisher
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> girlFindAll(GirlRepository girlRepository) {
        return RouterFunctions.route(RequestPredicates.GET("/girl/find/all"), request -> {
            // 返回所有的用户对象
            Collection<Girl> girls = girlRepository.findAll();
            Flux<Girl> girlFlux = Flux.fromIterable(girls);
            return ServerResponse.ok().body(girlFlux, Girl.class);
        });
    }
}
