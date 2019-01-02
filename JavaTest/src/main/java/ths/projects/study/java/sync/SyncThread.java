package ths.projects.study.java.sync;

/**
 * @author: wangrd
 * @since: 2019年01月02日 15:24:17
 * @Desc:
 */
public class SyncThread extends Thread {
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}
