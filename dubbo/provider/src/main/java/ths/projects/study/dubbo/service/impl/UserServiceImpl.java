package ths.projects.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ths.projects.study.dubbo.model.UserModel;
import ths.projects.study.dubbo.reponsotory.UserReponsitory;
import ths.projects.study.dubbo.service.UserService;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年09月28日 16:40:26
 * @Desc:
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserReponsitory reponsitory;

    @Override
    public UserModel getUser(int id) {
        return reponsitory.getUser(id);
    }

    @Override
    public List<UserModel> list() {
        return reponsitory.list();
    }
}
