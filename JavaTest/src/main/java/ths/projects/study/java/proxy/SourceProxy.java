package ths.projects.study.java.proxy;

/**
 * @author: wangrd
 * @since: 2019年01月06日 14:51:27
 * @Desc:
 */
public class SourceProxy implements Sourceable {
    private Source source;

    public SourceProxy() {
        super();
        this.source = new Source();
    }


    @Override
    public void print() {
        before();
        source.print();
        after();
    }

    private void before() {
        System.out.println("before proxy!");
    }

    private void after() {
        System.out.println("after proxy!");
    }
}
