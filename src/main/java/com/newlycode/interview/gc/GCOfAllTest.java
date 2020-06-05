package com.newlycode.interview.gc;

import java.util.Random;

/**
 * 七大垃圾回收器测试
 * 1- SerialGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC      (DefNew + Tenured)
 *
 * 2- ParNewGC
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC     (ParNew + Tenured)
 *  备注：
 *  Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector
 *  with the Serial old collector is deprecated and will likely be removed in a future release
 *
 * 3- ParallelGC 新生代的回收器
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC     (PSYoungGen + ParOldGen)
 *
 * 4- ParallelOldGC 老年代的回收器
 *  4.1- 手动添加
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC     (PSYoungGen + ParOldGen)
 *  4.2- 不加默认UseParallelGC
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags                           (PSYoungGen + ParOldGen)
 *
 * 5- ConcMarkSweepGC
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC   (par new generation + concurrent mark-sweep)
 *
 * 6- G1GC
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC               (后面单独讲)
 *
 * 7- SerialOldGC(理论知道即可，实际中已经被优化掉了，没有了。)
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC
 *
 * 下面是故意配置，学习为主，生产不建议这么配置！！！配置一个即可，然后会在另一个代使用另一种回收器，如上所示。
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC -XX:+UseParallelOldGC  (PSYoungGen + ParOldGen)
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC -XX:+UseConcMarkSweepGC  (par new generation + concurrent mark-sweep generation)
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/5 21:24
 */
public class GCOfAllTest {

    public static void main(String[] args) {
        System.out.println("GC demo");
        String str = "hello GC!";
        try {
            while (true) {
                str += str + new Random().nextInt(55555555) + new Random().nextInt(66666666);
                // 内存中存在就不再创建，使用内存中的
                str.intern();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
