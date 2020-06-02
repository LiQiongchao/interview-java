package com.newlycode.interview;

import org.junit.Test;

/**
 * @Author: LiQiongchao
 * @Date: 2020/6/1 22:47
 */
public class SystemUtilsTest {

    @Test
    public void availableProcessors() {
        // 获取电脑可用的核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
