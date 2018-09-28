package ths.project.thsboot.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ths.project.thsboot.model.User;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年07月21日 23:30:13
 * @Desc:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByNameLike(String name);
}
