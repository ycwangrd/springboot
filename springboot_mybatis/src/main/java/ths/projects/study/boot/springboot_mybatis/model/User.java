package ths.projects.study.boot.springboot_mybatis.model;

import lombok.*;

/**
 * @author: wangrd
 * @since: 2018年09月29日 15:37:58
 * @Desc:
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer userId;

    @NonNull
    private String userName;

    @NonNull
    private String password;

    private String phone;

    public User(String userName, String password, String phone) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

}
