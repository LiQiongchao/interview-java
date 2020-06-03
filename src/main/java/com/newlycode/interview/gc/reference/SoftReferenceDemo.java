package com.newlycode.interview.gc.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用
 *  内存够用的情况下不回收，内存不够用的情况下就回收。
 * 模拟内存不够的情况，设置内存大小为5M
 *  -Xms5m -Xmx5m -XX:+PrintGCDetails
 * 然后创建一个大数组，使内存溢出。
 * @Author: LiQiongchao
 * @Date: 2020/6/3 19:41
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
//        memoryEnough();
//        memoryNotEnough();
    }

    public static void memoryEnough() {
        // 这样默认是强引用
        Object object1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object1);
        System.out.println(object1);
        System.out.println(softReference.get());

        // object1置空
        object1 = null;
        // 手动回收
        System.gc();
        System.out.println(object1);
        // 由于内存充足softReference还存在
        System.out.println(softReference.get());
    }

    public static void memoryNotEnough() {
        // 这样默认是强引用
        Object object1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object1);
        System.out.println(object1);
        System.out.println(softReference.get());

        // object1置空
        object1 = null;

        try {
            Byte[] b = new Byte[5 * 1024 * 1024];
        } finally {
            System.out.println(object1);
            // 由于内存不充足softReference已经不存在
            System.out.println(softReference.get());
        }

    }

}
