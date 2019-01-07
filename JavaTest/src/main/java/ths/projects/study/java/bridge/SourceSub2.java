package ths.projects.study.java.bridge;

import ths.projects.study.java.bridge.Sourceable;

/**
 * @author: wangrd
 * @since: 2019年01月06日 15:06:45
 * @Desc:
 */
public class SourceSub2 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the second sub!");
    }
}
