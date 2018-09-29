package ths.projects.study.boot.springboot_mybatis.dao;

import ths.projects.study.boot.springboot_mybatis.model.User;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年09月29日 15:39:39
 * @Desc:
 */
public interface UserDao {
    /**
     * 保存用户信息
     *
     * @param entity    用户对象
     * @return
     */
    int insert(User entity);

    /**
     * 用户信息列表
     *
     * @return
     */
    List<User> list();

    /**
     * 清空表
     */
    void clear();
}
