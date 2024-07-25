package org.crawler.shopping.user.dao.repo;

import org.crawler.shopping.user.dao.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsernameEquals(String username);

    SysUser findByUsernameAndPassword(String username, String password);
}
