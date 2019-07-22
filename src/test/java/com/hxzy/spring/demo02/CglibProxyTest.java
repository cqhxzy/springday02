package com.hxzy.spring.demo02;

import org.junit.Test;

import static org.junit.Assert.*;

public class CglibProxyTest {

    @Test
    public void demo02(){
        UserDao dao = new UserDao() {
            @Override
            public void save() {
                System.out.println("正在执行save().....");
            }
        };
        UserDao proxy = new CglibProxy(dao).createProxy();
        proxy.save();

    }

}