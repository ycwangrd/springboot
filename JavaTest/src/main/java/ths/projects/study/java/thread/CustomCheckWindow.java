package ths.projects.study.java.thread;

import java.util.concurrent.Semaphore;

/**
 * @author: wangrd
 * @since: 2019年01月06日 11:11:49
 * @Desc:
 */
public class CustomCheckWindow {
    public static void main(String[] args) {
        // 设定3个信号量,即3个服务窗口
        Semaphore semaphore = new Semaphore(1);

        // 这个队伍排了5个人
        for (int i = 1; i <= 5; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }
    }

    private static class SecurityCheckThread extends Thread {
        private int seq;
        private Semaphore semaphore;

        SecurityCheckThread(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No." + seq + "乘客,正在检查中..");
                // 假设号码是整除2的人是身份可疑人员,需要花更长时间来安检
                if (seq % 2 == 0) {
                    Thread.sleep(3000);
                    System.out.println("No." + seq + "乘客,身份可疑,不能出国!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("No." + seq + "乘客已经完成服务.");
            }
        }
    }
}
