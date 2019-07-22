package com.hxzy.spring.demo01;

import org.junit.Test;

import static org.junit.Assert.*;

public class JdkProxyTest {

    @Test
    public void demo01(){
        UserDao userDao = new UserDaoImpl();

        UserDao proxy = new JdkProxy(userDao).createProxy();
        proxy.save();

    }

}