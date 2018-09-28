package ths.projects.study.dubbo.service;

import ths.projects.study.dubbo.model.UserModel;

/**
 * @author: wangrd
 * @since: 2018年09月27日 14:51:45
 * @Desc:
 */
public interface UserService {
    UserModel getUser(int id);
}
