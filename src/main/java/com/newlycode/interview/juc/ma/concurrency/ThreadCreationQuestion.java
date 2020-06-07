package com.newlycode.interview.juc.ma.concurrency;

/**
 * 创建线程的方式只有一个，就是new Thread()
 * @Author: LiQiongchao
 * @Date: 2020/6/6 16:51
 */
public class ThreadCreationQuestion {
    public static void main(String[] args) {
        // main 线程 -> 子线程
        Thread thread = new Thread(() -> {

        }, "子线程-1");
    }

    /**
     * 不建议这样使用
     */
    private static class MyThread extends Thread {

        /**
         * 多态的方法，覆盖父类的方法
         */
        @Override
        public void run() {
            super.run();
        }
    }


}
