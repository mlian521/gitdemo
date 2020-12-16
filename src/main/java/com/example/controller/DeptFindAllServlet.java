package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.Comm;
import com.example.common.Res;
import com.example.common.SpringIOC;
import com.example.dao.entity.Dept;
import com.example.service.iservice.IDeptService;
import com.example.service.iservice.IReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DeptFindAllServlet",urlPatterns = {"/deptall"})
public class DeptFindAllServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDeptService deptService= (IDeptService) SpringIOC.getSpringIOC().getBean("deptService");
        Res<List<Dept>> res =deptService.findAll();

        //System.out.println("sdfhjbop"+res.getData());
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(res));
        out.close();
    }
}
//        if (res.getData()!=null&&res.getData().size()>0)
//        if (res.getStatus()==200){
//
//        }