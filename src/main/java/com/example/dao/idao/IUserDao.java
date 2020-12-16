package com.example.dao.idao;

import com.example.dao.entity.User;

public interface IUserDao {
    int exist(String username) throws Exception;

    User login(User user)throws Exception;
}
