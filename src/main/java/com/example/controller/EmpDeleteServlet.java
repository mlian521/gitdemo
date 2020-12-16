package com.example.controller;

import com.example.common.Comm;
import com.example.common.SpringIOC;
import com.example.dao.entity.Emp;
import com.example.service.iservice.IEmpService;
import com.example.service.iservice.IReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmpDeleteServlet",urlPatterns = {"/empdelete"})
public class EmpDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int empno=Integer.parseInt(req.getParameter("empno"));
        IEmpService empService= (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        Emp emp=new Emp();
        emp.setEmpno(empno);
        String msg=empService.delete(emp);
        if (Comm.SUCCESS.equals(msg)){
            resp.sendRedirect(req.getContextPath()+"/empbypage");
        }
        else {
            HttpSession session=req.getSession();
            session.setAttribute("errMsg","员工数据删除失败");
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }
}
