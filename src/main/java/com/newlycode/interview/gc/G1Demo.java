package com.newlycode.interview.gc;

import java.util.Random;

/**
 * 测试G1垃圾回收
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/5 22:09
 */
public class G1Demo {

    public static void main(String[] args) {
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
