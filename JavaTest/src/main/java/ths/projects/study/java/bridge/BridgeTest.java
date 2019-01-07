package ths.projects.study.java.bridge;

/**
 * @author: wangrd
 * @since: 2019年01月06日 15:12:44
 * @Desc:
 */
public class BridgeTest {
    public static void main(String[] args) {
        SourceBridge bridge = new MyBridge();

        // 调用第一个对象
        Sourceable source1 = new SourceSub1();
        bridge.setSource(source1);
        bridge.method();

        // 调用第二个对象
        Sourceable source2 = new SourceSub2();
        bridge.setSource(source2);
        bridge.method();
    }
}
