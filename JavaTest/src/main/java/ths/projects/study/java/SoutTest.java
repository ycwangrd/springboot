package ths.projects.study.java;

/**
 * @author: wangrd
 * @since: 2018年11月25日 22:31:50
 * @Desc:
 */
public class SoutTest {
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            System.out.println("++++++" + i);
        }
    }
}
