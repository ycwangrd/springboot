package ths.projects.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import ths.projects.study.dubbo.model.UserModel;
import ths.projects.study.dubbo.service.UserService;

/**
 * @author: wangrd
 * @since: 2018年09月27日 14:52:14
 * @Desc:
 */

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public UserModel getUser(int id) {
        switch (id) {
            case 1:
                return new UserModel(id, "Kaly Chen", 36, "中国汉中");
            case 2:
                return new UserModel(id, "Devin Chen", 37, "中国西安");
            case 3:
                return new UserModel(id, "Chris Chen", 38, "中国上海");
            default:
                return new UserModel(id, "Fabio Chen", 39, "中国");
        }
    }
}
