package com.newlycode.interview.gc.reference;

import java.nio.file.Watchable;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * WeakHashMap
 *  在GC的时候，就会回收里面的键值对
 * @Author: LiQiongchao
 * @Date: 2020/6/3 20:11
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("=====================");
        myWeakHashMap();
    }

    private static void myHashMap() {
        // 强引用
        HashMap<Integer, String> map = new HashMap<>();
        Integer integer = new Integer(12);
        map.put(integer, "hashMap");
        System.out.println(map);

        integer = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void myWeakHashMap() {
        // 强引用
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer integer = new Integer(14);
        map.put(integer, "hashMap");
        System.out.println(map);

        integer = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }
}
