package ths.projects.study.java.sync;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author: wangrd
 * @since: 2019年01月02日 16:00:58
 * @Desc:
 */
public class ShareData {

    public static int count = 0;

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    private static ExecutorService threadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        final ShareData data = new ShareData();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                try {
                    //进入的时候暂停1毫秒，增加并发问题出现的几率
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 100; j++) {
                    data.addCount();
                }
                System.out.println(count + " ");
            });
        }
        try {
            //主程序暂停3秒，以保证上面的程序执行完成
            Thread.sleep(3000);
            threadPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count=" + count);
    }

    public void addCount() {
        count++;
    }
}
