package com.newlycode.interview.gc.reference;

/**
 * 强引用为默认引用
 *  无论内存够不够用，都不会回收强引用
 * @Author: LiQiongchao
 * @Date: 2020/6/3 19:37
 */
public class StrongReference {

    public static void main(String[] args) {
        // 这样默认是强引用
        Object object1 = new Object();
        Object object2 = object1;
        System.out.println(object1);
        System.out.println(object2);

        // object1置空
        object1 = null;
        // 手动回收
        System.gc();
        System.out.println(object1);
        // object2还存在
        System.out.println(object2);
    }

}
