package com.newlycode.interview.gc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * java.lang.OutOfMemoryError: Metaspace 异常测试
 * 一直创建静态类，直到元空间用完
 * JVM参数：-XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 *
 * Cglib Enhancer参考：https://www.cnblogs.com/micrari/p/7565632.html
 * @Author: LiQiongchao
 * @Date: 2020/6/3 21:37
 */
public class MetaSpaceOOMDemo {

    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println("**********多少次后异常：i = " + i);
            e.printStackTrace();
        }
        /*
        **********多少次后异常：i = 279
        java.lang.OutOfMemoryError: Metaspace
            at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:237)
            at net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:377)
            at net.sf.cglib.proxy.Enhancer.create(Enhancer.java:285)
            at com.newlycode.interview.gc.MetaSpaceOOMDemo.main(MetaSpaceOOMDemo.java:32)
         */
    }

    static class OOMTest{}
}
