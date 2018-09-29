package ths.projects.study.dubbo.reponsotory;

import org.springframework.stereotype.Component;
import ths.projects.study.dubbo.model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: wangrd
 * @since: 2018年09月28日 16:41:42
 * @Desc:
 */
@Component
public class UserReponsitory {
    
    public static ConcurrentMap<Integer, UserModel> userMap = new ConcurrentHashMap<>(100);
    
    public UserModel getUser(int id) {
        return userMap.get(id);
    }
    
    public List<UserModel> list(){
        return new ArrayList<>(userMap.values());
    }
}
