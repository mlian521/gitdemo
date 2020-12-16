package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.common.Comm;
import com.example.common.Res;
import com.example.common.SpringIOC;
import com.example.controller.vo.DelVO;
import com.example.service.iservice.IEmpService;
import com.example.service.iservice.IReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpDelBatchServlet",urlPatterns = {"/empdelbatch"})
public class EmpDelBatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empnos=request.getParameter("empnos");
        List<DelVO> delVOList=JSON.parseObject(empnos,new TypeReference<List<DelVO>>(){});
        IEmpService empService= (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        Res res=empService.delBatch(delVOList);
        PrintWriter out=response.getWriter();
        out.println(JSON.toJSONString(res));
        out.close();
    }

}
