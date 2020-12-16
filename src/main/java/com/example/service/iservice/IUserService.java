package com.example.service.iservice;

import com.example.common.Res;
import com.example.dao.entity.User;

public interface IUserService {
    Res userExist(String username);

    Res<User> login(User user);
}
