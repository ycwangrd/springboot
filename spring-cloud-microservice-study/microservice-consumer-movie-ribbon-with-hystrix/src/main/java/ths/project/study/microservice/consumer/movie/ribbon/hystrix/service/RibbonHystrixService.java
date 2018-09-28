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

package ths.project.study.microservice.consumer.movie.ribbon.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ths.project.study.microservice.consumer.movie.ribbon.hystrix.entity.User;

/**
 * @author: wangrd
 * @since: 2018年09月19日 18:14:57
 */
@Service
public class RibbonHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     *
     * @param id
     * @return 通过id查询得到用户
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(Long id) {
        return restTemplate.getForObject("http://microservice-consumer-movie-ribbon/ribbon/user/get/" + id, User.class);
    }

    /**
     * hystrix fallback方法
     *
     * @param id
     * @return 默认的用户
     */
    public User fallback(Long id) {
        logger.info("异常发生,进入fallback方法,接收的参数:id={}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }
}
