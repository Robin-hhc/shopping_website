package org.crawler.shopping.user.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String username;

    @JsonIgnore
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    private String avatarUrl;
    private String role;
    private String newPassword;
}
