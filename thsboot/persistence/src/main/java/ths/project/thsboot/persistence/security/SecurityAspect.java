package ths.project.thsboot.persistence.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: wangrd
 * @since: 2018年07月29日 19:30:44
 * @Desc: 切面
 */
@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private AuthService authService;

    /**
     * 这种方式也有侵入性
     */
    @Pointcut("@annotation(AdminOnly)")
    public void adminOnly() {

    }

    @Before("adminOnly()")
    public void check() {
        authService.checkAccess();
    }

    /**
     * 切面声明
     */
    @Pointcut("within(ths.project.thsboot.persistence.service.*.list)")
    public void listAuth() {
        System.out.println("listAuth()");
    }

    @Before("listAuth()")
    public void checkList() {
        authService.checkAccess();
    }
}
