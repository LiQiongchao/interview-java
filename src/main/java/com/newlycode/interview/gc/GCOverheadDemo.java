package com.newlycode.interview.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Java.lang.OutOfMemeoryError:GC overhead limit exceeded
 * 当GC发生多次，无法回收更多垃圾时，就会抛出该异常。
 *
 * 为了快速见效，调小堆内存与元空间的内存（使用的直接内存）
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/3 21:00
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(i++ + "");
            }
        } catch (Throwable throwable) {
            System.out.println("----------- i = " + i);
            throwable.printStackTrace();
            throw throwable;
        }
    }

}
