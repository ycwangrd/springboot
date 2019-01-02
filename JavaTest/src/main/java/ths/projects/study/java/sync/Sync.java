package ths.projects.study.java.sync;

/**
 * @author: wangrd
 * @since: 2019年01月02日 15:23:07
 * @Desc:
 */
public class Sync {
    public synchronized void test() {
        System.out.println("test开始..");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");
    }
}
