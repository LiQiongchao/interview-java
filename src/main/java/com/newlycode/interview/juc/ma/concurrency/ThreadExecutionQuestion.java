package com.newlycode.interview.juc.ma.concurrency;

/**
 * 线程的执行顺序 t1, t2, t3
 *
 * 思考：wait 谁通知的thread停止wait
 *      - see more: https://blog.csdn.net/chenkaibsw/article/details/80912878
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/6 17:17
 */
public class ThreadExecutionQuestion {

    public static void main(String[] args) throws InterruptedException {
        threadWait();
    }


    /**
     * wait实现
     */
    private static void threadWait() throws InterruptedException {
        Thread t1 = new Thread(ThreadExecutionQuestion::action, "t1");
        Thread t2 = new Thread(ThreadExecutionQuestion::action, "t2");
        Thread t3 = new Thread(ThreadExecutionQuestion::action, "t3");
        threadStarAndWait(t1);
        threadStarAndWait(t2);
        threadStarAndWait(t3);
    }

    private static void threadStarAndWait(Thread thread) {

        if (Thread.State.NEW.equals(thread.getState())) {
            thread.start();
        }

        while (thread.isAlive()) {
            synchronized (thread) {
                try {
                    thread.wait(); // 到底是谁通知 Thread -> thread.notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    /**
     * sleep实现
     */
    private static void threadSleep() throws InterruptedException {
        Thread t1 = new Thread(ThreadExecutionQuestion::action, "t1");
        Thread t2 = new Thread(ThreadExecutionQuestion::action, "t2");
        Thread t3 = new Thread(ThreadExecutionQuestion::action, "t3");
        t1.start();
        while (t1.isAlive()) {
            Thread.sleep(0);
        }
        t2.start();
        while (t2.isAlive()) {
            Thread.sleep(0);
        }
        t3.start();
        while (t3.isAlive()) {
            Thread.sleep(0);
        }
    }

    /**
     * 自旋实现
     */
    private static void threadLoop() throws InterruptedException {
        Thread t1 = new Thread(ThreadExecutionQuestion::action, "t1");
        Thread t2 = new Thread(ThreadExecutionQuestion::action, "t2");
        Thread t3 = new Thread(ThreadExecutionQuestion::action, "t3");
        t1.start();
        while (t1.isAlive()) {}
        t2.start();
        while (t2.isAlive()) {}
        t3.start();
        while (t3.isAlive()) {}
    }

    private static void thradJoinOneByOne() throws InterruptedException {
        Thread t1 = new Thread(ThreadExecutionQuestion::action, "t1");
        Thread t2 = new Thread(ThreadExecutionQuestion::action, "t2");
        Thread t3 = new Thread(ThreadExecutionQuestion::action, "t3");
        t1.start();
        // join控制线程必须执行完成
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }

    private static void action() {
        System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());
    }

}
