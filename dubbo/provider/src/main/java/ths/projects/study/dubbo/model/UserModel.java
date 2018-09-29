package ths.projects.study.dubbo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: wangrd
 * @since: 2018年09月28日 16:35:23
 * @Desc:
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel implements Serializable {
    private int id;
    private String name;
    private int age;
}

