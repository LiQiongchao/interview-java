package com.newlycode.interview.juc.ma.concurrency;

import java.util.concurrent.*;

/**
 * 线程池的异常捕获
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/7 21:34
 */
public class ThreadPoolExecutionQuestion {

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2000)
        ){
            /**
             * 通过覆盖{@link ThreadPoolExecutor#afterExecute(Runnable, Throwable)}达到获取异常的方式
             * @param r
             * @param t
             */
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.printf("线程%s 异常了, 详细信息：%s \n", Thread.currentThread().getName(), t.getMessage());
            }
        };

        executorService.execute(() -> {
            throw new RuntimeException("异常了");
        });
        // 等待一秒钟， 确保提交的任务完成
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        //　关闭线程池
        executorService.shutdown();
    }
}
