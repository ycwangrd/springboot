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

package ths.project.study.microservice.provider.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ths.project.study.microservice.provider.user.entity.User;
import ths.project.study.microservice.provider.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年08月18日 19:16:26
 * @Desc: ①测试服务实例的相关内容
 * ②为后来的服务做提供
 */
@RestController
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户的列表信息
     * 
     * @return
     */
    @GetMapping(value = "/user/list")
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    /**
     * 通过主键id查询用户
     *
     * @param id 用户主键
     * @return user信息
     */
    @GetMapping(value = "/user/get/{id}")
    public User findById(@PathVariable Long id) {
        User findOne = userRepository.getOne(id);
        return findOne;
    }

    /**
     * 获取本地实例的服务
     * 
     * @return
     */
    @GetMapping(value = "/instance-info")
    public List<ServiceInstance> showInfo() {
        List<ServiceInstance> instances = new ArrayList<>();
        List<String> services = discoveryClient.getServices();
        services.forEach(serviceId -> instances.addAll(discoveryClient.getInstances(serviceId)));
        return instances;
    }
}
