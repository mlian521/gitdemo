package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.Comm;
import com.example.common.Res;
import com.example.dao.entity.Emp;
import com.example.service.factory.ServiceFactory;
import com.example.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpFindByDeptServlet",urlPatterns = {"/empbydept"})
public class EmpFindByDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deptno=Integer.parseInt(request.getParameter("deptno"));
        IEmpService empService= (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        Res<List<Emp>> result=empService.findByDept(deptno);
        //System.out.println("555555522222"+result);
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(result));
        out.close();
    }
}
