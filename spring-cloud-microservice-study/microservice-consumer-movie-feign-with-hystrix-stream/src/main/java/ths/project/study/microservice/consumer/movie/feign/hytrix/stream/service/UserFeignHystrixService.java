/*
 *  Copyright(C) 2000-2011 THS Technology Limited Company, http://www.ths.com.cn
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package ths.project.study.microservice.consumer.movie.feign.hytrix.stream.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ths.project.study.microservice.consumer.movie.feign.hytrix.stream.entity.User;

/**
 * @author: wangrd
 * @since: 2018年09月19日 19:09:28
 * 使用@FeignClient注解的fallback属性，指定fallback类
 */
@FeignClient(name = "microservice-provider-user", fallback = UserFeignHystrixService.HystrixServiceFallback.class)
public interface UserFeignHystrixService {

    @RequestMapping("/user/get/{id}")
    User findByIdFeign(@RequestParam("id") Long id);

    /**
     * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     *
     * @author wangrd
     */
    @Component
    class HystrixServiceFallback implements UserFeignHystrixService {
        private final Logger logger = LoggerFactory.getLogger(getClass());

        /**
         * hystrix fallback方法
         *
         * @param id id
         * @return 默认的用户
         */
        @Override
        public User findByIdFeign(Long id) {
            logger.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
            User user = new User();
            user.setId(-1L);
            user.setUsername("default username");
            user.setAge(0);
            return user;
        }
    }
}
