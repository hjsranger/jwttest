package com.hjs.jwt.controller;

import com.hjs.jwt.model.User;
import com.hjs.jwt.utils.JwtUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jianshuang_huang on 2018/10/19.
 */
@RestController
public class LoginController {


    @PostMapping("/login")
    public String login(@RequestBody User user, HttpServletResponse response, HttpServletRequest request){

        System.out.println(user.getUsername() +" "+user.getPasswd());

        String token = JwtUtils.getToken(user.getUsername());

        System.out.println("Token:"+token);

        request.setAttribute("token",token);

        return token;

    }

    @PostMapping("/check")
    public String check(){

        return null;
    }


}
