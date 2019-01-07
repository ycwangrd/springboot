package ths.projects.study.java.bridge;

/**
 * @author: wangrd
 * @since: 2019年01月06日 15:05:57
 * @Desc:
 */
public class SourceSub1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
