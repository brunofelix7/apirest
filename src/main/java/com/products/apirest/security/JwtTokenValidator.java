package com.products.apirest.security;

import com.products.apirest.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenValidator {

    private String secret = "youtube";

    public User validate(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        User user = new User();
        user.setUsername(body.getSubject());
        user.setId(Long.parseLong((String) body.get("id")));
        user.setRole((String) body.get("role"));
        return user;
    }
}
