package ths.projects.study.java.thread;

import java.util.concurrent.Future;

/**
 * @author: wangrd
 * @since: 2019年01月05日 22:15:18
 * @Desc:
 */
public class Test01 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Runnable runnable = createThrea("string" + i);
            Thread thread = new Thread(runnable);
            Thread.UncaughtExceptionHandler eh = (t, e) -> {
                System.out.println(t);
                System.out.println(e);
            };
            thread.setUncaughtExceptionHandler(eh);
            Future<?> future = Executors.services.submit(thread);
            System.out.println(future);
        }
    }

    public static Runnable createThrea(final String string) {
        return () -> {
            try {
                System.out.println(string);
                System.out.println(1 / 0);
            } catch (Exception e) {
                System.out.println(e);
            }
        };
    }
}
