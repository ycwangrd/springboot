package ths.projects.study.boot.springboot_mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ths.projects.study.boot.springboot_mybatis.dao.UserDao;
import ths.projects.study.boot.springboot_mybatis.model.User;
import ths.projects.study.boot.springboot_mybatis.service.UserService;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年09月29日 15:52:06
 * @Desc:
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; //这里会报错，但是并不会影响

    @Override
    public int addUser(User entity) {
        return userDao.insert(entity);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<User> list(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.list();
        PageInfo result = new PageInfo(users);
        return result;
    }

    @Override
    public void clear() {
        userDao.clear();
    }

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void batchInsert(String insertStatementId, List<User> userList) {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        int count = 0;
        if (StringUtils.isNotBlank(insertStatementId) && userList != null && !userList.isEmpty()) {
            for (User user : userList) {
                count++;
                sqlSession.insert(insertStatementId, user);
                if (count % 100 == 0 || count == userList.size()) {
                    sqlSession.flushStatements();
                }
            }
        }
    }
}
