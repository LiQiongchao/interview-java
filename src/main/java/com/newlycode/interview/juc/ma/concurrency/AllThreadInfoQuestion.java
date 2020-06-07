package com.newlycode.interview.juc.ma.concurrency;

import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

/**
 * 如何获取当前线程的资源消费情况
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/7 21:49
 */
public class AllThreadInfoQuestion {

    public static void main(String[] args) {
        // 获取当前线程的资源消费情况
        /** 注意: {@link com.sun.management.ThreadMXBean} */
        ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.getAllThreadIds();
        for (long threadInfo : threadIds) {
            ThreadInfo threadInfo1 = threadMXBean.getThreadInfo(threadInfo);
            System.out.println(threadInfo1.toString());
            long bytes = threadMXBean.getThreadAllocatedBytes(threadInfo);
            long mbytes = bytes / 1024;
            System.out.printf("线程[id：%d] 分配内存： %s KB", threadInfo, mbytes);
        }

    }

}
