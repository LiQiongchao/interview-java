package com.newlycode.interview;

import org.junit.Test;

import java.util.Hashtable;

/**
 * @Author: LiQiongchao
 * @Date: 2020/6/5 21:28
 */
public class StringTest {

    @Test
    public void internTest() {
        String str1 = "helloworld";
        String str2 = new String("helloworld");
        System.out.println(str1 == str2);
        String internStr = new String("helloworld").intern();
        System.out.println(internStr == str1);
        // false true
    }

    @Test
    public void nullTest() {
        String test = null;
        // java.lang.NullPointerException
//        System.out.println(test.hashCode());

        Hashtable hashtable = new Hashtable();
        // java.lang.NullPointerException
        hashtable.put(test, "aa");
    }

}
