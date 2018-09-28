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

package ths.project.study.microservice.consumer.movie.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ths.project.study.microservice.consumer.movie.ribbon.entity.User;
import ths.project.study.microservice.consumer.movie.ribbon.service.RibbonService;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年08月25日 11:28:26
 */
@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @RequestMapping(value = "/ribbon/user/get/{id}")
    public User findById(@PathVariable("id") Long id) {
        return this.ribbonService.findById(id);
    }

    @GetMapping(value = "/ribbon/user/list")
    public List<User> getAll() {
        return this.ribbonService.findAll();
    }

    @GetMapping(value = "/ribbon/instance-info")
    public List<ServiceInstance> showInfo() {
        return this.ribbonService.showInfo();
    }
}
