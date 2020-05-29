package com.newlycode.interview.juc;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock测试
 * 和ReadWriteLock相比，写入的加锁是完全一样的，不同的是读取。注意到首先我们通过tryOptimisticRead()获取一个乐观读锁，
 * 并返回版本号。接着进行读取，读取完成后，我们通过validate()去验证版本号，如果在读取过程中没有写入，版本号不变，验证成功，
 * 我们就可以放心地继续后续操作。如果在读取过程中有写入，版本号会发生变化，验证将失败。在失败的时候，
 * 我们再通过获取悲观读锁再次读取。由于写入的概率不高，程序在绝大部分情况下可以通过乐观读锁获取数据，
 * 极少数情况下使用悲观读锁获取数据。
 *
 * 可见，StampedLock把读锁细分为乐观读和悲观读，能进一步提升并发效率。但这也是有代价的：一是代码更加复杂，
 * 二是StampedLock是不可重入锁，不能在一个线程中反复获取同一个锁。
 *
 * StampedLock还提供了更复杂的将悲观读锁升级为写锁的功能，它主要使用在if-then-update的场景：即先读，
 * 如果读的数据满足条件，就返回，如果读的数据不满足条件，再尝试写。
 * @author Liqc
 * @date 2020/5/29 12:15
 */
public class StampedLockDemo {

}

class Point {
    private Double x, y;
    private final StampedLock lock = new StampedLock();

    void move(double deltaX, double deltaY) {
        // 获得写锁
        long stamp = lock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            // 释放写锁
            lock.unlockWrite(stamp);
        }
    }

    /**
     * 乐观锁的应用
     * @return
     */
    double distanceFromOrigin() {
        // 尝试获取一个乐观锁
        long stamp = lock.tryOptimisticRead();
        // 注意下面的两行代码不是原子操作
        // 假设x,y=(100, 200)
        double currentX = x;
        // 此处读取到的x=100，但x,y可能被写成（300，400）
        double currentY = y;
        //此处已读取到y，如果没有写入，读取是正确的（100，200）
        // 如果有写入，读取的是错误的（100，400）

        // 检查乐观锁后是否有其他写锁发生
        if (!lock.validate(stamp)) {
            // 获取一个悲观读锁
            stamp = lock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                // 释放悲观读锁
                lock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    /**
     * 悲观锁的应用
     * @param newX
     * @param newY
     */
    void moveIfAtOrigin(double newX, double newY) {
        // 获取一个读锁
        long stamp = lock.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                // 如果在原点就尝试去转换成一个写锁
                long writeStamp = lock.tryConvertToWriteLock(stamp);

                // 转换成功
                if (writeStamp != 0L) {
                    stamp = writeStamp;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    // 转换失败就直接释放再获取一个写锁，再去走判断
                    lock.unlockRead(stamp);
                    stamp = lock.writeLock();
                }
            }
        } finally {
            // 释放锁
            lock.unlock(stamp);
        }
    }
}
