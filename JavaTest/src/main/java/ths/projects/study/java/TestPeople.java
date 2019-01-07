package ths.projects.study.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: wangrd
 * @since: 2019年01月07日 16:07:07
 * @Desc:
 */
public class TestPeople {
    private static final Logger logger = LoggerFactory.getLogger(TestPeople.class);
    String name;

    public TestPeople() {
        System.out.println(1);
    }

    public TestPeople(String name) {
        System.out.println(2);
        this.name = name;
    }
}

class Child extends TestPeople {
    TestPeople people;

    public Child(String name) {
        System.out.println(3);
        this.name = name;
        people = new TestPeople(name + "F");
    }

    public Child() {
        System.out.println(4);
    }
}

class AA {
    public static void main(String[] args) {
        new Child("张三");
    }
}
