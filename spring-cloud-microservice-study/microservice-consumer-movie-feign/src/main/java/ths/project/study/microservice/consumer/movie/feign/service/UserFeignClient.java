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

package ths.project.study.microservice.consumer.movie.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ths.project.study.microservice.consumer.movie.feign.entity.User;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年09月19日 15:31:40
 */

/**
 * 使用@FeignClient(name = "microservice-provider-user")注解绑定microservice-provider-user服务,
 * 还可以使用url参数指定一个URL
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping("/user/get/{id}")
    User findByIdFeign(@RequestParam("id") Long id);

    @RequestMapping(value = "/user/list")
    List<User> listFeign();
}
