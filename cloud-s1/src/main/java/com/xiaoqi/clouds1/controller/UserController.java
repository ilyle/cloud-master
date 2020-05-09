package com.xiaoqi.clouds1.controller;

import com.xiaoqi.clouds1.domain.User;
import com.xiaoqi.clouds1.domain.common.Response;
import com.xiaoqi.clouds1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.xiaoqi.clouds1.domain.common.Response.CODE_ERROR;
import static com.xiaoqi.clouds1.domain.common.Response.CODE_SUCCESS;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 自动注入UserService
     */
    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Response<User> login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if (user != null) {
            return new Response<>(CODE_SUCCESS, "", user);
        } else {
            return new Response<>(CODE_ERROR, "账号密码不匹配", null);
        }
    }

    @RequestMapping(value = "login/token", method = RequestMethod.POST)
    public Response<User> loginWithToken(HttpServletRequest request) {
        String token = request.getParameter("token");
        User user = userService.loginWithToken(token);
        if (user != null) {
            return new Response<>(CODE_SUCCESS, "", user);
        } else {
            return new Response<>(CODE_ERROR, "自动登录失败", null);
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public Response<User> logout(HttpServletRequest request) {
        String uid = request.getParameter("uid");
        User user = userService.logout(uid);
        if (user != null) {
            return new Response<>(CODE_SUCCESS, "", user);
        } else {
            return new Response<>(CODE_ERROR, "参数错误", null);
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Response<User> register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.register(username, password);
        if (user != null) {
            return new Response<>(CODE_SUCCESS, "", user);
        } else {
            return new Response<>(CODE_ERROR, "参数错误", null);
        }
    }

}
