package com.abc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DeptDaoTest {
    @Autowired
    DeptDao deptDao;
    @Test
    public void findAll() {
        deptDao.findAll().forEach(System.out::println);
    }
    @Test
    public void one2many() {
        deptDao.one2many().forEach((dept)->{
            System.out.println(dept.getDname());
            System.out.println("***********************");
            dept.getStus().forEach(System.out::println);
            System.out.println("###########################");
        });
    }
}