package com.hxzy.spring.demo02;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

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

    @Test
    public void demo03(){
        assertThat(new Double(5),closeTo(new Double(5),new Double(0.3)));
    }

}