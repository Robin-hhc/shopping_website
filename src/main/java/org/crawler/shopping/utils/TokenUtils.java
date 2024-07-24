package org.crawler.shopping.utils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.crawler.shopping.config.ServiceException;
import org.crawler.shopping.constants.Constant;

import java.util.Objects;

public class TokenUtils {
    public static String getToken(String username, String userId) {
        String token = JWT.create().withAudience().sign(Algorithm.HMAC256(username));
        return token;
    }

    public static boolean validateLogin(){
        try{
            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
            String token = request.getHeader("token");
            if(StringUtils.hasLength(token)){
                JWT.decode(token).getAudience();
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            throw new ServiceException(Constant.CODE_401, "Login in session expired！");
        }
    }
}
