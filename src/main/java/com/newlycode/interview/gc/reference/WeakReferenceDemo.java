package com.newlycode.interview.gc.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 弱引用
 *  只要有GC就会回收。
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/3 19:41
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object object1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(object1);
        System.out.println(object1);
        System.out.println(weakReference.get());

        // object1置空
        object1 = null;
        // 手动回收
        System.gc();
        System.out.println(object1);
        // 不管内存是否充足，只有GC发生，弱引用就会被回收。
        System.out.println(weakReference.get());
    }
}
