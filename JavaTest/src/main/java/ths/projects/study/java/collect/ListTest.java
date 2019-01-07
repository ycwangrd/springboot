package ths.projects.study.java.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: wangrd
 * @since: 2019年01月05日 17:38:38
 * @Desc:
 */
public class ListTest {

    private static final int size = 100000;

    public static void main(String[] args) throws InterruptedException {
        arrayListTest();
        linkedListTest();
        queueTest();
        System.out.println(Arrays.asList(1, 2, 3));
        Arrays.asList(1, 2, 3, 4).stream().forEach(x -> System.out.println(x));
        Arrays.asList(1, 2, 3, 4).stream().forEach(System.out::println);
        System.out.println(System.nanoTime());
    }

    private static void queueTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        for (int i = 0; i < size; i++) {
            strings.put("string" + i);
        }
        for (int i = 0; i < size; i++) {
            strings.poll();
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Queue耗时:%d", end - start));
        for (int i = 0; i < size; i++) {
            strings.remove("string" + i);
        }
        end = System.currentTimeMillis();
        System.out.println(String.format("Queue耗时:%d", end - start));
    }

    private static void arrayListTest() {
        long start = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>(1);
        for (int i = 0; i < size; i++) {
            arrayList.add("string" + i);
        }
        for (int i = 0; i < size; i++) {
            arrayList.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("ArrayList:耗时:%d", end - start));
        for (int i = 0; i < size; i++) {
            arrayList.remove(0);
        }
        end = System.currentTimeMillis();
        System.out.println(String.format("ArrayList:耗时:%d", end - start));
    }

    private static void linkedListTest() {
        long start = System.currentTimeMillis();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add("string" + i);
        }
        for (int i = 0; i < size; i++) {
            linkedList.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("LinkedList:耗时:%d", end - start));
        for (int i = 0; i < size; i++) {
            linkedList.remove(0);
        }
        end = System.currentTimeMillis();
        System.out.println(String.format("LinkedList:耗时:%d", end - start));
    }
}
