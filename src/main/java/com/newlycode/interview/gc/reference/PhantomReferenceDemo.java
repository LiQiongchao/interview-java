package com.newlycode.interview.gc.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 *  与不存在一样，无法使用，只能在对象回收时做一此处理。
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/3 19:41
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        Object object1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object1, referenceQueue);

        System.out.println(object1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=====================");
        object1 = null;
        System.gc();
        Thread.sleep(500L);

        System.out.println(object1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }
}
