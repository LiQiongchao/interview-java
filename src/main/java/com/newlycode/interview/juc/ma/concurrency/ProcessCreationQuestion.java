package com.newlycode.interview.juc.ma.concurrency;

import java.io.IOException;

/**
 * Java启动一个进程
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/6 17:03
 */
public class ProcessCreationQuestion {

    public static void main(String[] args) throws IOException {
        // 获取java的Runtime
        Runtime runtime = Runtime.getRuntime();
        // 打开计算器
//        Process process = runtime.exec("calc");
        // 在浏览器打开百度
        Process process = runtime.exec("cmd /k start http://www.baidu.com");
        process.exitValue();
    }

}
