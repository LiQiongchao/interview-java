package com.newlycode.interview.juc.ma.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * ShutdownHookQuestion是在程序消亡的时候执行的，可以在里面处理一些事件。
 * @Author: LiQiongchao
 * @Date: 2020/6/7 22:56
 */
public class ShutDownHookQuestion {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(ShutDownHookQuestion::action, "Shutdown Hook Question"));
        TimeUnit.SECONDS.sleep(5);
    }

    private static void action() {
        System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());
    }

}
