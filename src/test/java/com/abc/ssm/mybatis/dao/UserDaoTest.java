package com.abc.ssm.mybatis.dao;

import com.abc.ssm.mybatis.dao.entity.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoTest {
    @Autowired
    UserDao userDao;
    @Test
    public void findById() {
        System.out.println(userDao.findById(1));
        System.out.println(userDao.findById(11));
    }

    @Test
    public void findAll() {
        userDao.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void findByPage() {
        userDao.findByPage(2,2).forEach(System.out::println);
    }

    @Test
    public void findByName() {
        userDao.findByName("a").forEach(System.out::println);
        //userDao.findByName("' or 1=1 or '' ='").forEach(System.out::println);
    }

    @Test
    public void testSave(){
        User user=new User("zhou",new BigDecimal("12345"),new Date());
        int flag=userDao.save(user);
        TestCase.assertTrue(flag>0);
        findAll();

    }
    @Test
    public void testUpdate(){
        User user=userDao.findById(6);
        user.setUsername("ZHOU**");
        user.setSal(new BigDecimal("54321"));
        userDao.update(user);
        findAll();

    }
    @Test
    public void testDelete(){
        userDao.delete(7);
        findAll();
    }
}