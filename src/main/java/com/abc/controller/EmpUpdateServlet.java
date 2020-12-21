package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.SpringIOC;
import com.abc.dao.entity.Emp;
import com.abc.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EmpUpdateServlet",urlPatterns = {"/empupdate"})
public class EmpUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno=Integer.parseInt(request.getParameter("empno"));
        String ename=request.getParameter("ename");
        Date hiredate=null;
        try {
            hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
        }catch (Exception e){
            e.printStackTrace();
        }
        BigDecimal sal=new BigDecimal(request.getParameter("sal"));
        IEmpService empService= (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        Emp emp=new Emp(empno,ename,hiredate,sal);
        String msg=empService.update(emp);
        if (Comm.SUCCESS.equals(msg)){
            response.sendRedirect(request.getContextPath()+"/empbypage");
        }
        else {
            HttpSession session=request.getSession();
            session.setAttribute("errMsg","员工数据更新失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
