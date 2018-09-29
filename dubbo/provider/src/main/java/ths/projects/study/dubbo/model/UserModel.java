package ths.projects.study.dubbo.model;

/**
 * @author: wangrd
 * @since: 2018年09月28日 16:35:23
 * @Desc:
 */
public class UserModel {
    private int id;
    private String name;
    private int age;

    public UserModel(){
        
    }
    
    public UserModel(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
