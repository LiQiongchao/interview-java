package com.newlycode.interview.juc.ma.collection;

import java.util.concurrent.*;

/**
 * @Author: LiQiongchao
 * @Date: 2020/6/8 20:43
 */
public class BlockingQueueQuiz {

    public static void main(String[] args) throws InterruptedException {
        offer(new ArrayBlockingQueue<>(2));
        offer(new LinkedBlockingQueue<>(2));
        offer(new PriorityBlockingQueue<>(2));
        offer(new SynchronousQueue<>());
        /*
        queue.getClass() = java.util.concurrent.ArrayBlockingQueue
        queue.getClass() = true
        queue.offer(2) = true
        queue.offer(3) = false
        queue.size() = 2
        queue.take() = 1
        queue.getClass() = java.util.concurrent.LinkedBlockingQueue
        queue.getClass() = true
        queue.offer(2) = true
        queue.offer(3) = false
        queue.size() = 2
        queue.take() = 1
        queue.getClass() = java.util.concurrent.PriorityBlockingQueue
        queue.getClass() = true
        queue.offer(2) = true
        queue.offer(3) = true
        queue.size() = 3
        queue.take() = 1
        queue.getClass() = java.util.concurrent.SynchronousQueue
        queue.getClass() = false
        queue.offer(2) = false
        queue.offer(3) = false
        queue.size() = 0
        一直阻塞。。
         */
    }

    private static void offer(BlockingQueue<Object> queue) throws InterruptedException {
        System.out.println("queue.getClass() = " + queue.getClass().getName());
        System.out.println("queue.getClass() = " + queue.offer(1));
        System.out.println("queue.offer(2) = " + queue.offer(2));
        System.out.println("queue.offer(3) = " + queue.offer(3));
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.take() = " + queue.take());
    }
}
