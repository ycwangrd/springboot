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

package ths.project.study.microservice.consumer.movie.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ths.project.study.microservice.consumer.movie.feign.entity.User;
import ths.project.study.microservice.consumer.movie.feign.service.UserFeignClient;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年09月19日 15:34:21
 */
@RestController
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/feign/user/get/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        User user = userFeignClient.findByIdFeign(id);
        return user;
    }
    
    @GetMapping("/feign/user/list")
    public List<User> listFeign() {
        List<User> userList = userFeignClient.listFeign();
        return userList;
    }
}
