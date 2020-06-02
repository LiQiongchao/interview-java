package com.newlycode.interview.arithmetic.daily;

/**
 * 根据参数求自然数前N个数的和。
 *  不能使用乘法，for,while,if,else,switch,case,三位运算符等关键字及条件判断语句。
 *  方法一(不可用)： (1+n)*n/2, for/while
 *  方法二： 递归 O(n)
 *  方法三： 快乘表
 *
 * @author Liqc
 * @date 2020/6/2 9:29
 */
public class SumNatureNumber {

    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }

    public static int sumNums(int s) {
        boolean b = (s > 0) && (s += sumNums(s - 1)) > 0;
        return s;
    }

}
