package org.tugas.util;

import io.smallrye.jwt.build.Jwt;
import org.tugas.model.User;

import java.time.Duration;
import java.util.Date;

public class JwtUtil {

    public static String generateToken(User user){
        return Jwt
                .issuer("526c99b243436982cff03eb722971b43d0524d5d6aa5001b8ccf8dec6d2c03e8")
                .issuedAt(new Date().toInstant())
                .expiresIn(Duration.ofHours(1))
                .subject(user.getLoginName())
                .claim("email", user.getEmail())
                .claim("mobilePhoneNumber", user.getMobilePhoneNumber())
                .claim("fullName", user.getFullName())
                .sign();

    }
}
