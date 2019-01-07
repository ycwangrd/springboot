package ths.projects.study.java.startprocess;

/**
 * @author: wangrd
 * @since: 2019年01月06日 14:59:32
 * @Desc:
 */
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startUp() {
        System.out.println("startup the computer!");
        cpu.startUp();
        memory.startUp();
        disk.startUp();
        System.out.println("startup computer finished!");
    }

    public void shutdown() {
        System.out.println("shutdown the computer!");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("shutdown computer fineshed!");
    }
}
