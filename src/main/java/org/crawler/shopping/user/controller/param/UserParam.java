package org.crawler.shopping.user.controller.param;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserParam {
    @NotBlank(message = "Username can not be empty")
    private String username;
    @NotBlank(message = "Password can not be empty")
    private String password;
}
