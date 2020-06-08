package com.newlycode.interview.juc.ma.concurrency;

/**
 * 在主线程退出时，执行完所有线程。利用线程组。
 * @Author: LiQiongchao
 * @Date: 2020/6/8 19:24
 */
public class CompleteAllThreadsQuestion {

    public static void main(String[] args) {
        Thread t1 = new Thread(CompleteAllThreadsQuestion::action, "t1");
        Thread t2 = new Thread(CompleteAllThreadsQuestion::action, "t2");
        Thread t3 = new Thread(CompleteAllThreadsQuestion::action, "t3");

        // 不确定上面三个线程是否调用 start()
        t1.start();
        t2.start();
        t3.start();

        // 创建了 N 个线程
        Thread mainThread = Thread.currentThread();
        ThreadGroup threadGroup = mainThread.getThreadGroup();
        int activeNum = threadGroup.activeCount();
        Thread[] threads = new Thread[activeNum];
        // 把所有线程枚举到数组里面去, recurse 递归取线程组中子线程组的线程
        int enumerate = threadGroup.enumerate(threads, true);
        for (Thread thread : threads) {
            System.out.printf("当前活跃线程：%s\n", thread.getName());
        }


    }


    private static void action() {
        System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());
    }

}
