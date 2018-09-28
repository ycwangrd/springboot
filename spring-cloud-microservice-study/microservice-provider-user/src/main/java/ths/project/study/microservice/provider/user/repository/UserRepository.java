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

package ths.project.study.microservice.provider.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ths.project.study.microservice.provider.user.entity.User;

/**
 * @author: wangrd
 * @since: 2018年08月18日 19:13:42
 * @Desc:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
