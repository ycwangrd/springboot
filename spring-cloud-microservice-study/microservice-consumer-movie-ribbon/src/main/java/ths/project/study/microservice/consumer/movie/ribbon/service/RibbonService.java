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

package ths.project.study.microservice.consumer.movie.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ths.project.study.microservice.consumer.movie.ribbon.entity.User;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年08月25日 11:25:53
 */
@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    // TODO 要读取配置文件中的配置
    @Value("${microservice-provider-user.serviceUrl}")
    private String providerUrl;// = "http://microservice-provider-user";

    public User findById(Long id) {
        // http://服务提供者的serviceId/url
        return this.restTemplate.getForObject(providerUrl + "/user/get/" + id, User.class);
    }

    public List<User> findAll() {
        return this.restTemplate.getForObject(providerUrl + "/user/list", List.class);
    }

    public List<ServiceInstance> showInfo() {
        return this.restTemplate.getForObject(providerUrl + "/instance-info", List.class);
    }
}
