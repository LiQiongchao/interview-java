package com.newlycode.interview.juc;

import java.util.concurrent.*;

/**
 * Callable<V> 具有回调的接口测试
 *
 * @author Liqc
 * @date 2020/6/2 12:12
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask task = new FutureTask(myThread);
        new Thread(task, "AA").start();
        // 因为上面已经执行了task，这个线程就不再执行，直接调用task的结果
//        new Thread(task, "BB").start();

        // task.get()会阻塞当前线程，直到task执行完成，获取结果后，才会往下执行。
        System.out.println(task.get());
    }

}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("这是一个有回调的callable接口");
        TimeUnit.SECONDS.sleep(2);
        return "计算完成！";
    }
}
