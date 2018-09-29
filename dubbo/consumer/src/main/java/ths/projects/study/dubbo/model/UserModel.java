package ths.projects.study.dubbo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: wangrd
 * @since: 2018年09月28日 16:35:23
 * @Desc:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserModel implements Serializable {
    private int id;
    private String name;
    private int age;
}
