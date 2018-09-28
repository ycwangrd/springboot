package ths.project.thsboot.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: wangrd
 * @since: 2018年07月20日 22:41:25
 * @Desc:
 */
@Entity
@Data
@ToString
public class Girl {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer girlId;

    private String name;

    private Integer age;

    private String cupSize;

}
