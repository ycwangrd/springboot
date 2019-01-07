package ths.projects.study.java.bridge;

/**
 * @author: wangrd
 * @since: 2019年01月06日 15:08:20
 * @Desc:
 */
public abstract class SourceBridge {
    private Sourceable source;

    public void method() {
        source.method();
    }

    /**
     * @return the source
     */
    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}

class MyBridge extends SourceBridge {
    @Override
    public void method() {
        getSource().method();
    }
}
