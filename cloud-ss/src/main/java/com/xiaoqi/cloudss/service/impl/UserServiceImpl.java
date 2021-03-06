package com.xiaoqi.cloudss.service.impl;

import com.xiaoqi.cloudss.constant.Constant;
import com.xiaoqi.cloudss.domain.User;
import com.xiaoqi.cloudss.repository.UserRepository;
import com.xiaoqi.cloudss.service.UserService;
import com.xiaoqi.cloudss.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {
        long ts = System.currentTimeMillis();
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        if (user == null) {
            return null;
        } else {
            String token = Md5Util.getMD5Str(username + user.getUid() + ts);
            long tsTokenExpire = ts + Constant.TS_3_DAYS;
            user.setIsLogin(true); // 更新为登录状态
            user.setToken(token); // 更新token
            user.setTsTokenExpire(tsTokenExpire); // 更新token过期时间
            userRepository.save(user);
            return user;
        }
    }

    public User loginWithToken(String token) {
        long ts = System.currentTimeMillis(); // 当前时间戳
        User user = userRepository.findUserByToken(token);
        if (user != null && ts <= user.getTsTokenExpire()) { // token未过期
            String newToken = Md5Util.getMD5Str(user.getUsername() + user.getUid() + ts);
            long tsTokenExpire = ts + Constant.TS_3_DAYS; // 刷新token过期时间戳
            user.setIsLogin(true);
            user.setToken(newToken);
            user.setTsTokenExpire(tsTokenExpire);
            userRepository.save(user);
            return user;
        } else { // token已过期
            return null;
        }
    }

    public User logout(String uid) {
        User user = userRepository.findUserByUid(uid);
        if (user != null) {
            user.setIsLogin(false);
            user.setTsTokenExpire(0);
            userRepository.save(user);
            return user;
        } else {
            return null;
        }
    }

    public User register(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user != null) { // 用户名已被注册
            return null;
        } else {
            User newUser = new User();
            long ts = System.currentTimeMillis();
            String uid = Md5Util.getMD5Str(username + ts);
            newUser.setUid(uid);
            newUser.setUsername(username);
            newUser.setPassword(password);
            userRepository.save(newUser);
            return newUser;
        }
    }
}
