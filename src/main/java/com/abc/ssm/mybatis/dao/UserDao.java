package com.abc.ssm.mybatis.dao;

import com.abc.ssm.mybatis.dao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public User findById(@Param("userId") Integer userId);
    public List<User> findAll();
    List<User> findByPage(@Param("start") Integer start,@Param("size") Integer size);
    List<User> findByName(@Param("username") String username);
    int save(User user);
    int update(User newuser);
    int delete(Integer userId);
}
