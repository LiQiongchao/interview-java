package com.newlycode.interview.juc.ma.concurrency;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author: LiQiongchao
 * @Date: 2020/6/7 21:49
 */
public class AllThreadStackQuestion {

    public static void main(String[] args) {
        // 获取当前线程的Jvm所有的线程状态
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadInfos = threadMXBean.getAllThreadIds();
        for (long threadInfo : threadInfos) {
            ThreadInfo threadInfo1 = threadMXBean.getThreadInfo(threadInfo);
            System.out.println(threadInfo1.toString());
        }

    }

}
