package com.hxzy.spring.demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class JdkProxy implements InvocationHandler {

    private UserDao userDao;

    public JdkProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao createProxy(){
        UserDao proxyInstance = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), this);

        return  proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       if (method.getName().equals("save")) {
            System.out.println("开始执行方法前的验证工作");
            Object invoke = method.invoke(userDao,args);
            System.out.println("验证得到结果后的方法执行");
            return invoke;
        }

        return method.invoke(userDao,args);
    }
}
