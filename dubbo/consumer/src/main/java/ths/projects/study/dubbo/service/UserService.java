package ths.projects.study.dubbo.service;

import ths.projects.study.dubbo.model.UserModel;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年09月28日 16:39:18
 * @Desc:
 */
public interface UserService {
    
    UserModel getUser(int id);
    
    List<UserModel> list();
}
