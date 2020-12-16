package com.example.controller.report;

import com.alibaba.fastjson.JSON;
import com.example.common.Comm;

import com.example.common.Res;
import com.example.common.SpringIOC;
import com.example.controller.vo.DeptEmpVO;
import com.example.service.dto.DeptEmpDTO;
import com.example.service.iservice.IReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "ReportDeptEmpServlet",urlPatterns = {"/reportDeptEmp"})
public class ReportDeptEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deptno=Integer.parseInt(request.getParameter("deptno"));
        BigDecimal minSal=new BigDecimal(request.getParameter("min"));
        BigDecimal maxSal=new BigDecimal(request.getParameter("max"));
        //assemble vo
        DeptEmpVO deptEmpVO=new DeptEmpVO(deptno,minSal,maxSal);
        IReportService reportService= (IReportService) SpringIOC.getSpringIOC().getBean("reportService");
        Res<List<DeptEmpDTO>> res= reportService.makeReportForDeptEmp(deptEmpVO);
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(res));
        out.close();

    }
}
