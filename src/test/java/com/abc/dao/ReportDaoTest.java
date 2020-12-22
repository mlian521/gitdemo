package com.abc.dao;

import com.abc.controller.vo.DeptEmpVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ReportDaoTest {
    @Autowired
    ReportDao reportDao;
    @Test
    public void makeReportForDeptEmp() {
        reportDao.makeReportForDeptEmp(new DeptEmpVO(2,new BigDecimal("1200"),new BigDecimal(1600))).forEach(System.out::println);
    }
}