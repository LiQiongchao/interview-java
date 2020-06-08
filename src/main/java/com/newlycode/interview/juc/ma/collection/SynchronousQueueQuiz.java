package com.newlycode.interview.juc.ma.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author: LiQiongchao
 * @Date: 2020/6/8 20:34
 */
public class SynchronousQueueQuiz {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        /*
        1. SynchronousQueue 是无空间的，offer 永远返回 false
        2. SynchronousQueue take() 方法会被阻塞，必须被其它线程显示地调用 put(Object)
         */
        System.out.println("queue.offer(1) = " + queue.offer(1));
        System.out.println("queue.offer(2) = " + queue.offer(2));
        System.out.println("queue.offer(3) = " + queue.offer(3));
        System.out.println("queue.take() = " + queue.take());
        System.out.println("queue.size() = " + queue.size());
        /*
        queue.offer(1) = false
        queue.offer(2) = false
        queue.offer(3) = false
        一直阻塞
         */
    }

}
