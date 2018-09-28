package ths.project.thsboot.persistence.security;

import org.springframework.stereotype.Component;

/**
 * @author: wangrd
 * @since: 2018年07月29日 09:55:09
 * @Desc:
 */
@Component
public class AuthService {

    public void checkAccess() {
        String user = CurrentUserHolder.getUser();
        if (!"admin".equalsIgnoreCase(user)) {
            throw new RuntimeException("operation is not allow");
        }
    }
}
