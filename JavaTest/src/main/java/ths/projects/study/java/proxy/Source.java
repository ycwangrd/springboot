package ths.projects.study.java.proxy;

/**
 * @author: wangrd
 * @since: 2019年01月06日 14:50:38
 * @Desc: 被代理类
 */
public class Source implements Sourceable {

    @Override
    public void print() {
        System.out.println("the original method!");
    }
}
