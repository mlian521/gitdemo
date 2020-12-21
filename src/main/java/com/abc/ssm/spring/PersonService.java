package com.abc.ssm.spring;


public class PersonService implements IPersonService {

    @Override
    public void log() {
        System.out.println("personService log..........");
    }

    @Override
    public void tx() {
        System.out.println("personService tx.......");
    }
}
