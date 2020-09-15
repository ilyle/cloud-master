package com.xiaoqi.cloudss.controller;

import com.xiaoqi.cloudss.domain.User;
import com.xiaoqi.cloudss.domain.common.Response;
import com.xiaoqi.cloudss.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.xiaoqi.cloudss.domain.common.Response.CODE_ERROR;
import static com.xiaoqi.cloudss.domain.common.Response.CODE_SUCCESS;

@Api(description = "User接口")
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController extends BaseController{

    /**
     * 自动注入UserService
     */
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String")})
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Response<User> login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        log.info(String.format("login请求参数：username = %s, password = %s", username, password));
        User user = userService.login(username, password);
        if (user != null) {
            return new Response<>(CODE_SUCCESS, "", user);
        } else {
            return new Response<>(CODE_ERROR, "账号密码不匹配", null);
        }
    }

    @ApiOperation(value = "token登录")
    @ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String")
    @RequestMapping(value = "login/token", method = RequestMethod.POST)
    public Response<User> loginWithToken(@RequestParam(name = "token") String token) {
        log.info(String.format("login/token请求参数：token = %s", token));
        User user = userService.loginWithToken(token);
        if (user != null) {
            return new Response<>(CODE_SUCCESS, "", user);
        } else {
            return new Response<>(CODE_ERROR, "自动登录失败", null);
        }
    }

    @ApiOperation("退出")
    @ApiImplicitParam(name = "logout", value = "uid", required = true, paramType = "query", dataType = "String")
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public Response<User> logout(@RequestParam("uid") String uid) {
        log.info(String.format("logout请求参数：uid = %s", uid));
        User user = userService.logout(uid);
        if (user != null) {
            return new Response<>(CODE_SUCCESS, "", user);
        } else {
            return new Response<>(CODE_ERROR, "参数错误", null);
        }
    }

    @ApiOperation(value = "注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String")})
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Response<User> register(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        log.info(String.format("register请求参数：username = %s, password = %s", username, password));
        User user = userService.register(username, password);
        if (user != null) {
            return new Response<>(CODE_SUCCESS, "", user);
        } else {
            return new Response<>(CODE_ERROR, "参数错误", null);
        }
    }

}
