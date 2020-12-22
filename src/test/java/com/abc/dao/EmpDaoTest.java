package com.abc.dao;

import com.abc.dao.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmpDaoTest {
    @Autowired
    EmpDao empDao;
    @Test
    public void findByPage() {
        empDao.findByPage(1,3).forEach(System.out::println);
    }

    @Test
    public void findByName() {
        empDao.findByName("a").forEach(System.out::println);
    }

    @Test
    public void findById() {

    }

    @Test
    public void delete() {
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findByDept() {
        empDao.findByDept(2).forEach(System.out::println);
    }

    @Test
    public void findByCon() throws ParseException {
        Date hiredate=new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-01");
        empDao.findByCon("u",hiredate,new BigDecimal("1200")).forEach(System.out::println);
        System.out.println("*************************************");
        empDao.findByCon(null,hiredate,new BigDecimal("1200")).forEach(System.out::println);
        System.out.println("*************************************");
        empDao.findByCon(null,null,new BigDecimal("1200")).forEach(System.out::println);
        System.out.println("*************************************");
        empDao.findByCon(null,null,null).forEach(System.out::println);
    }

    @Test
    public void dynamicUpdate(){
        Emp emp=new Emp();
        emp.setEmpno(6);
        emp.setEname("WU**");
        emp.setSal(new BigDecimal("12345"));
        empDao.dynamicUpdate(emp);
    }

    @Test
    public void delBatch() {
        System.out.println(empDao.delBatch(Arrays.asList(12,13,14)));
        findByPage();
    }
    @Test
    public void saveBatch() {
        List<Emp> emps=Arrays.asList(
                new Emp("emp1001",new Date(),new BigDecimal("12345")),
                new Emp("emp1002",new Date(),new BigDecimal("12345")),
                new Emp("emp1003",new Date(),new BigDecimal("12345")),
                new Emp("emp1004",new Date(),new BigDecimal("12345")),
                new Emp("emp1005",new Date(),new BigDecimal("12345"))
                );
        System.out.println(empDao.saveBatch(emps));
        findByPage();
    }

}