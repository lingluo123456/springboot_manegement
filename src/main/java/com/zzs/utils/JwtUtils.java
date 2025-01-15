package com.zzs.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * JwtUtils 工具类，用于生成和解析 JWT 令牌
 */
public class JwtUtils {
    // 签名密钥
    private static final String SECRET_KEY = "aXR6enM=";
    // 令牌过期时间，设置为 12 小时
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000;


    /**
     * 生成 JWT 令牌的方法
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }


    /**
     * 解析 JWT 令牌的方法
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

}