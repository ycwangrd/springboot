package ths.project.thsboot.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: wangrd
 * @since: 2018年07月21日 19:29:44
 * @Desc:
 */
@Entity
@Data // lombok 插件,自动getter和setter
@ToString
public class User {

    /**
     * 主键:自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 罩杯
     */
    private String cupSize;
}
