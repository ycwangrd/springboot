package ths.projects.study.boot.springboot_mybatis.service;

import com.github.pagehelper.PageInfo;
import ths.projects.study.boot.springboot_mybatis.model.User;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年09月29日 15:51:24
 * @Desc:
 */
public interface UserService {
    int addUser(User entity);

    PageInfo<User> list(int pageNum, int pageSize);
    
    void clear();
    
    void batchInsert(String insertStatementId, List<User> userList);
}
