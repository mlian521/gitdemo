package com.abc.ssm.spring;

import org.springframework.stereotype.Component;

@Component("math")
public class MathImpl implements IMath {
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void mul() {
        System.out.println("mul");
    }

    @Override
    public void sub() {
        System.out.println("sub");
    }

    @Override
    public void div() {
        System.out.println("div");
    }
}
