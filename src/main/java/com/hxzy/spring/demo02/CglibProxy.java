package com.hxzy.spring.demo02;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private UserDao userDao;

    public CglibProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao createProxy(){

        //创建cglib核心对象
        Enhancer enhancer = new Enhancer();

        //设置父类
        enhancer.setSuperclass(userDao.getClass());

        //设置回调（类似于JDK动态代理中的InvocationHandler）
        enhancer.setCallback(this);
        return null;
    }

    /**
     * 这个方法类似于InvocationHandler中的invoke方法
     * @param proxy 被代理的对象
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("save")) {
            //进行方法增强
            before();
            Object invoke = methodProxy.invoke(proxy, args);
            after();
            return invoke;
        }
        return methodProxy.invoke(proxy, args);
    }

    public void before(){
        System.out.println("----------before------------");
    }

    public void after(){
        System.out.println("-----------after----------");
    }
}
