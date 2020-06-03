package com.newlycode.interview.gc.reference;

/**
 * 强引用为默认引用
 *  无论内存够不够用，都不会回收强引用
 *
 * 模拟内存不够的情况，设置内存大小为5M
 *  -Xms5m -Xmx5m -XX:+PrintGCDetails
 * 然后创建一个大数组，使内存溢出。
 * @Author: LiQiongchao
 * @Date: 2020/6/3 19:37
 */
public class StrongReference {

    public static void main(String[] args) {
//        memoryEnough();
        memoryNotEnough();
    }

    private static void memoryEnough() {
        // 这样默认是强引用
        Object object1 = new Object();
        Object object2 = object1;
        System.out.println(object1);
        System.out.println(object2);

        // object1置空
        object1 = null;
        // 手动回收
        System.gc();
        System.out.println(object1);
        // object2还存在
        System.out.println(object2);
    }

    private static void memoryNotEnough() {
        // 这样默认是强引用
        Object object1 = new Object();
        Object object2 = object1;
        System.out.println(object1);
        System.out.println(object2);

        // object1置空
        object1 = null;
        // 手动回收
        System.gc();
        try {
            Byte[] bytes = new Byte[6 * 1024 * 1024];
        } finally {
            System.out.println(object1);
            // object2还存在，OOM也不会被回收
            System.out.println(object2);
        }
    }
}
