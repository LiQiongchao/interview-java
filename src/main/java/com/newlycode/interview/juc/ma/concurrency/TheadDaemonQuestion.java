package com.newlycode.interview.juc.ma.concurrency;

/**
 * 当 main 线程退出后，守护线程是否还会继续执行
 *  守护线程：（保姆）当非守护线程退出后，守护线程也会退出。如JVM就是一个守护线程，当没有线程存活时，JVM也会退出。
 *
 *  解：有可能会执行，也有可能会不执行，这是个不确定的事件，会评估根据守护线程使用的时间来确定是否执行。
 *  而且有的机器会执行，有的会不执行。
 * @Author: LiQiongchao
 * @Date: 2020/6/7 22:50
 */
public class TheadDaemonQuestion {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.printf("hello daemon!");
        });
        thread.setDaemon(true);
        thread.start();
    }
}
