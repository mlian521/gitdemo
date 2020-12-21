package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        IPersonService personService=new PersonServiceProxy();
//        personService.log();
//        personService.tx();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        IMath math= (IMath) ctx.getBean("mathProxy");
        math.div();
        math.add();
    }

}
