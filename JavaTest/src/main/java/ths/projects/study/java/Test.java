package ths.projects.study.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author: wangrd
 * @since: 2019年01月07日 16:01:42
 * @Desc:
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>(3);
        str.add("2");
        str.add("1");
        str.add("1");
        for (int i = 0; i < str.size(); i++) {
            if ("1".equals(str.get(i))) {
                str.remove(i);
            }
        }
        System.out.println(str.size());
    }
}
