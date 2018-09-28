package ths.project.thsboot.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ths.project.thsboot.model.User;
import ths.project.thsboot.persistence.repository.UserRepository;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年07月21日 23:31:42
 * @Desc:
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> list(String name) {
        if (StringUtils.hasText(name)) {
            return repository.findByNameLike("%" + name + "%");
        } else {
            return repository.findAll();
        }
    }
}
