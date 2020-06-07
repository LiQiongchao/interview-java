package com.newlycode.interview.juc.ma.concurrency;

/**
 * 在Java中，执行线程Java是没有办法销毁它的，
 * 但是当Thread.isAlive()返回false时，实际底层 Thread 已经被销毁了。
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/6 17:06
 */
public class ThreadStateQuestion {

    public static void main(String[] args) {
        // main 线程 -> 子线程
        Thread thread = new Thread(() -> {
            System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());
        }, "子线程-1");

        // 启动线程
        thread.start();

        //　先于子线程执行
        System.out.printf("线程[%s] 是否还活着： %s \n" , thread.getName(), thread.isAlive());
    }

}
