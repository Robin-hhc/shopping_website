package org.crawler.shopping.user.controller;

import jakarta.annotation.Resource;
import org.crawler.shopping.user.controller.ViewBean.UserViewBean;
import org.crawler.shopping.user.controller.param.UserParam;
import org.crawler.shopping.user.dao.entity.SysUser;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.crawler.shopping.user.service.UserService;
import org.crawler.shopping.utils.Result;
import org.crawler.shopping.utils.TokenUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.BeanUtils;

@CrossOrigin
@RestController
public class UserController {
    @Resource
    private UserService userServiceImpl;

    @PostMapping("/login")
    public Result login(@RequestBody UserParam userParam) {
        String username = userParam.getUsername();
        String password = userParam.getPassword();
        SysUser user = userServiceImpl.findUserByName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                UserViewBean viewBean = new UserViewBean();
                BeanUtils.copyProperties(user, viewBean);
                String token = TokenUtils.getToken(user.getId().toString(), user.getUsername());
                viewBean.setToken(token);
                return Result.ok().data("item", viewBean);
            } else {
                return Result.error(30006, "Password Incorrect");
            }
        } else {
            return Result.error(30006, "Username not exist");
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody @Validated UserParam userParam) {
        SysUser user = userServiceImpl.register(userParam.getUsername(), userParam.getPassword());
        UserViewBean viewBean = new UserViewBean();
        BeanUtils.copyProperties(user, viewBean);
        return Result.ok().data("item", viewBean);
    }

    @GetMapping("/userid/{id}")
    public long getUserId(@PathVariable String id) {
        SysUser user = userServiceImpl.findUserById(Long.valueOf(id));
        return user.getId();
    }
}
