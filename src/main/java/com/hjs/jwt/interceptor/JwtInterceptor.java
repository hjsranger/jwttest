package com.hjs.jwt.interceptor;

import com.hjs.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by jianshuang_huang on 2018/10/19.
 */
public class JwtInterceptor extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        String token = request.getParameter("token");

        Claims claims = JwtUtils.checkToken(token);
        request.setAttribute("username",claims.getSubject());
        return true;

    }


}
