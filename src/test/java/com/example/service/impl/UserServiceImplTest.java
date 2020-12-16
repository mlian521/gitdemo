package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.common.Comm;
import com.example.common.Res;
import com.example.service.factory.ServiceFactory;
import com.example.service.iservice.IUserService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

public class UserServiceImplTest {
    IUserService userService;
    private static Logger log=Logger.getLogger(UserServiceImplTest.class);
    @Before
    public void setUp(){
        userService= (IUserService) ServiceFactory.getInstance(Comm.USER);
    }
    @Test
    public void userExist() {
        Res res=userService.userExist("root");
        log.info("*****************************"+res);
    }
}