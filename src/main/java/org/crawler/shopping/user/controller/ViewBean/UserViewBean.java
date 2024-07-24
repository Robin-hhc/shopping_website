package org.crawler.shopping.user.controller.ViewBean;

import lombok.Data;

@Data
public class UserViewBean {
    private String username;
    private Long id;
    private String nickname;
    private String avatarUrl;
    private String token;
    private String role;
}
