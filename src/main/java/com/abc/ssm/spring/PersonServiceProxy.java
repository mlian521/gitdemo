package com.abc.ssm.spring;

public class PersonServiceProxy implements IPersonService{
    IPersonService personService;

    public PersonServiceProxy() {
        personService=new PersonService();
    }

    @Override
    public void log() {
        System.out.println("前置日志");
        personService.log();
        System.out.println("后置日志");
    }

    @Override
    public void tx() {
        System.out.println("启动事务");
        personService.tx();
        System.out.println("事务提交或者回滚");
    }
}
