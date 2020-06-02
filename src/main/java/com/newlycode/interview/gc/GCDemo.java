package com.newlycode.interview.gc;

/**
 * VM: -Xms10m -Xmx10m -XX:+PrintGCDetails
 * 放开bype数组，会oom，会打印gc日志，否则只打印堆栈信息，不打印GC与full GC的日志。
 * @Author: LiQiongchao
 * @Date: 2020/6/2 22:34
 */
public class GCDemo {

    public static void main(String[] args) {
        System.out.println("hello GC");
        Byte[] bytes = new Byte[50 * 1024 * 1024];
        System.out.println("==========================");
    }
}
