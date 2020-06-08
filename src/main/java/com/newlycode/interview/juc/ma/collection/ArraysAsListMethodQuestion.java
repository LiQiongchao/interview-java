package com.newlycode.interview.juc.ma.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: LiQiongchao
 * @Date: 2020/6/8 19:56
 */
public class ArraysAsListMethodQuestion {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 替换第三个元素
        list.set(2, 9);
        // Arrays.asList 并非线程安全
        list.forEach(System.out::println);

        // Java < 5 ，Collections#synchronizedList
        // Java 5+, CopyOnWriteArrayList
        // Java 9+, List.of();
    }
}
