package com.xiaoqi.cloudss.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id，唯一
     * md5(username + ts)
     */
    private String uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 由客户端对原始密码做MD5加密
     */
    private String password;

    /**
     * 用户登录成功赋予的token，可用于下次自动登录，有效期为3天
     * MD5(username + uid + ts)
     */
    private String token;

    /**
     * token过期时间戳
     */
    private long tsTokenExpire;

    /**
     * 是否登录
     */
    private boolean isLogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getTsTokenExpire() {
        return tsTokenExpire;
    }

    public void setTsTokenExpire(long tsTokenExpire) {
        this.tsTokenExpire = tsTokenExpire;
    }

}
