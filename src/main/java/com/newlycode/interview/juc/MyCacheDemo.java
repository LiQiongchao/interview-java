package com.newlycode.interview.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 利用ReentrantReadWriteLock的特性，写的时候只能单个线程写，读的时候可以多个读的特性，来模拟redis操作。
 * @Author: LiQiongchao
 * @Date: 2020/5/28 22:39
 */
public class MyCacheDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int val = i;
            new Thread(() -> {
                myCache.put(val+"", val*val +"");
            }, i + "").start();
        }
        for (int i = 0; i < 5; i++) {
            final int val = i;
            new Thread(() -> {
                myCache.get(val+"");
            }, i + "").start();
        }
    }
}

class MyCache {

    /**
     * 模拟内存存取
     */
    private volatile Map<String, String> map = new HashMap<>();

    /**
     * 读写锁
     * 只有写就会阻塞其它线程，读的时候可以多个线程去读，最多支持65535（2^16 - 1）个
     */
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t time="+System.currentTimeMillis()+"\t 正在写入，key=" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t time="+System.currentTimeMillis()+"\t 写入正在完成");
        } finally {
         lock.writeLock().unlock();
        }
    }

    public String get(String key) {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t time="+System.currentTimeMillis()+"\t 正在读取");
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String val = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t time="+System.currentTimeMillis()+"\t 读取正在完成，val=" + val);
            return val;
        } finally {
            lock.readLock().unlock();
        }
    }
}