package ths.projects.study.java.sync;

/**
 * @author: wangrd
 * @since: 2019年01月02日 15:20:20
 * @Desc:
 */
public class SyncTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SyncThread thread = new SyncThread();
            thread.run();
        }
    }
}
