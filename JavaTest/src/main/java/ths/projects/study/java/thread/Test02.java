package ths.projects.study.java.thread;

import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: wangrd
 * @since: 2019年01月05日 22:45:26
 * @Desc:
 */
public class Test02 {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        try {
            Future<?> future1 = Executors.services.submit(new TestThread1());
            System.out.println(future1.get());
            Future<?> future2 = Executors.services.submit(new TestThread2());
            System.out.println(future2.get());
            Future future3 = Executors.services.submit(new TestThread3());
            System.out.println(future3.get());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            Object call;
            try {
                call = new TestThread3().call();
            } catch (Exception e1) {
                call = e1;
            }
            System.out.println(call);
        } finally {
            System.exit(0);
        }
    }

    static class TestThread1 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Math.random());
                System.out.println(1 / 0);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static class TestThread2 extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(Math.random());
                System.out.println(1 / 0);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static class TestThread3 implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println(Math.random());
            return FORMAT.parse("yyyy-MM-dd");
        }
    }
}
