package org.crawler.shopping.user.service;
import org.crawler.shopping.user.dao.entity.SysUser;

public interface UserService {
    SysUser register(String username, String password);

    SysUser login(String username, String password);

    SysUser findUserById(Long id);

    SysUser findUserByName(String username);
}
