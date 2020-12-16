package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.Comm;
import com.example.common.Res;
import com.example.service.factory.ServiceFactory;
import com.example.service.iservice.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/UserExistServlet","/userexist"})
public class UserExistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1-取值
        String username=req.getParameter("username");
        //2-处理
        IUserService userService= (IUserService) ServiceFactory.getInstance(Comm.USER);
        Res res=userService.userExist(username);
        //3-反馈
        resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();
        Object resJson= JSON.toJSONString(res);
        out.println(resJson);
        out.close();
    }
}
