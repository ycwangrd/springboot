package ths.project.thsboot.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ths.project.thsboot.model.Girl;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年07月20日 22:50:32
 * @Desc:
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 通过姓名模糊匹配查询
     *
     * @param name 姓名
     * @return
     */
    List<Girl> findByNameLike(String name);
}
