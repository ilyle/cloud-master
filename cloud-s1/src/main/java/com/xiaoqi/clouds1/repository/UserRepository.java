package com.xiaoqi.clouds1.repository;


import com.xiaoqi.clouds1.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * 根据用户名查找用户
     */
    User findUserByUsername(String username);

    /**
     * 根据token查找用户名
     */
    User findUserByToken(String token);

    /**
     * 根据用户名和密码查询用户
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 根据uid查询用户
     */
    User findUserByUid(String uid);


}
