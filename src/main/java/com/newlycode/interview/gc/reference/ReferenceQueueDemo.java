package com.newlycode.interview.gc.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * ReferenceQueue的应用
 *  ReferenceQueue只有对象回收后，才会进入该队列。
 * @Author: LiQiongchao
 * @Date: 2020/6/3 20:24
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        Object object1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(object1, referenceQueue);

        System.out.println(object1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=====================");
        object1 = null;
        System.gc();
        Thread.sleep(500L);

        System.out.println(object1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }

}
