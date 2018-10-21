package com.hjs.jwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * Created by jianshuang_huang on 2018/10/19.
 */
public class JwtUtils {

    //私钥
    final static String base64EncodedSecretKey = "41dca17b-ce77-4308-8cc3-f9a56bffe81c";
    //过期时间，10分钟
    final static Long TOKEN_EXP = 1000*60*10L;

    /**
     * 获取Token
     * @param userName
     * @return
     */
    public static String getToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .claim("roles","user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+TOKEN_EXP))
                .signWith(SignatureAlgorithm.HS256,base64EncodedSecretKey)
                .compact();

    }


    public static Claims checkToken(String token) throws ServletException {

        try {
            final Claims claims = Jwts.parser().setSigningKey(base64EncodedSecretKey).parseClaimsJws(token).getBody();
            return claims;
        } catch (ExpiredJwtException e1) {
            System.out.println("登录信息过期，请重新登录");
        } catch (Exception e) {
            System.out.println("用户未登录，请重新登录");
        }

        return null;

    }

}
