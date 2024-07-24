package org.crawler.shopping.user.service.impl;

import jakarta.annotation.Resource;
import org.crawler.shopping.config.ServiceException;
import org.crawler.shopping.user.dao.entity.SysUser;
import org.crawler.shopping.user.dao.repo.SysUserRepository;
import org.crawler.shopping.user.service.UserService;
import org.crawler.shopping.constants.Constant;

public class UserServiceImpl implements UserService {
    @Resource
    SysUserRepository sysUserRepository;

    @Override
    public SysUser register(String username, String password) {

        if (sysUserRepository.findByUsername(username) != null) {
            throw new ServiceException(Constant.CODE_403,"Username is used by another user");
        } else {
            SysUser sysUser = new SysUser();
            sysUser.setUsername(username);
            sysUser.setPassword(password);
            sysUserRepository.save(sysUser);
            return sysUser;
        }
    }

    @Override
    public SysUser login(String username, String password) {
        return sysUserRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public SysUser findUserById(Long id) {
        return sysUserRepository.findById(id).get();
    }

    public SysUser findUserByName(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
