package com.newlycode.interview.juc.ma.concurrency;

/**
 * @Author: LiQiongchao
 * @Date: 2020/6/7 22:03
 */
public class SynchronizedKeywordQuestion {
    public static void main(String[] args) {

    }

    private static void synchronizedBlock() {
        synchronized (SynchronizedKeywordQuestion.class) {
        }
    }
    private synchronized static void action() {
    }
}
