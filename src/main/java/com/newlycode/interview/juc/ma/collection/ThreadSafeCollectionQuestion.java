package com.newlycode.interview.juc.ma.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: LiQiongchao
 * @Date: 2020/6/8 19:40
 */
public class ThreadSafeCollectionQuestion {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
        Set<Integer> set = Set.of(1, 2, 4, 5);
        Map<Integer, String> map = Map.of(1, "A");

        // 以 of 创建的对象是不可变的。

        // 实现一
        // 通过 Collections#synchronized* 方法返回
        //Ｗrapper 设计模式，所有的方法都被 synchronized 修饰
        list = Collections.synchronizedList(list);

        set = Collections.synchronizedSet(set);

        map = Collections.synchronizedMap(map);

        // 实现二
        list = new CopyOnWriteArrayList<>(list);
        set = new CopyOnWriteArraySet<>(set);
        map = new ConcurrentHashMap<>(map);

    }
}
