package ths.project.thstest.test;

/**
 * @author: wangrd
 * @since: 2018年08月07日 09:24:41
 * @Desc:
 */
public class Person {
    private String name;

    /**
     * 如果有有参构造方法,那就必须有无参构造方法,
     * 子类的构造方法,默认会调用父类的无参构造
     */
    public Person() {
        System.out.print(1);
    }

    public Person(String name) {
        System.out.print(2);
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Child extends Person {
    public Child() {
        System.out.print(3);
    }

    public Child(String name) {
        System.out.print(4);
        this.setName(name);
    }

    public static void main(String[] args) {
        new Child();
        new Child("name");
    }
}
