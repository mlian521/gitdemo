package com.abc.dao;

import com.abc.dao.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int exist(@Param("username") String username);
    User login(User user);
}
