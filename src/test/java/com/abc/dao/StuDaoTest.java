package com.abc.dao;

import com.abc.dao.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StuDaoTest {
    @Autowired
    StuDao stuDao;
//    @Test
//    public void one2one() {
//        stuDao.one2one().forEach((stu)->{
//            System.out.println(stu.getSid()+":"+stu.getSname());
//            System.out.println(stu.getDept());
//            System.out.println("***********************************");
//        });
//    }
    @Test
    public void getScoreInfo(){
        List<Student> stus=stuDao.getScoreInfo();
        for (Student student:stus){
            System.out.println(student.getSid()+"*"+student.getSname()+":");
            student.getScores().forEach((score)->{
                System.out.println(score.getCourse().getCname()+":"+score.getScore());
            });
            System.out.println("******************************************");
        }
    }
}