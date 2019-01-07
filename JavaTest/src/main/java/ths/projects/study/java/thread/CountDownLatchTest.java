package ths.projects.study.java.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: wangrd
 * @since: 2019年01月06日 10:55:32
 * @Desc:
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        TranslateThread thread1 = new TranslateThread("1st content", count);
        TranslateThread thread2 = new TranslateThread("2nd content", count);
        TranslateThread thread3 = new TranslateThread("3rd content", count);
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        count.await(10, TimeUnit.SECONDS);
        System.out.println("所有线程执行完毕.");
    }
}

class TranslateThread extends Thread {
    private Random random = new Random();
    
    private String content;
    private final CountDownLatch count;


    TranslateThread(String content, CountDownLatch count) {
        this.content = content;
        this.count = count;
    }

    @Override
    public void run() {
        // 在某种情况下,执行翻译解析时,跑出异常
        if (random.nextDouble() > 0.5) {
            throw new RuntimeException("源文件存在非法字符.");
        }
        System.out.println(content + "的翻译已经完成,译文是...");
        count.countDown();
    }
}
