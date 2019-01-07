package ths.projects.study.java.thread;

/**
 * @author: wangrd
 * @since: 2019年01月05日 23:21:10
 * @Desc:
 */
public class VolatileNotAtomic {
    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        SubtractThread thread = new SubtractThread();
        thread.start();
        for (int i = 0; i < NUMBER; i++) {
            synchronized (VolatileNotAtomic.class) {
                count++;
            }
        }
        while (thread.isAlive()) {
        }
        System.out.println("count最后的结果为:" + count);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                synchronized (VolatileNotAtomic.class) {
                    count--;
                }
            }
        }
    }
}
