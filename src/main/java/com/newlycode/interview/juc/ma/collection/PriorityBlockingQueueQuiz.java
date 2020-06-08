package com.newlycode.interview.juc.ma.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * PriorityBlockingQueue
 * put时不阻塞，不限制，还自然排序
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/8 20:26
 */
public class PriorityBlockingQueueQuiz {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(2);
        queue.put(9);
        queue.put(1);
        queue.put(8);
        // 因为有自然排序，所以放入的顺序是1，8，9
        System.out.println("queue size = " + queue.size());
        System.out.println("queue take = " + queue.take());
        System.out.println("queue = " + queue);
        /*
        queue size = 3
        queue take = 1
        queue = [8, 9]
         */
    }
}
