package com.newlycode.interview.arithmetic.top100;

import jdk.nashorn.internal.ir.CallNode;

/**
 * 【简单】7. 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Liqc
 * @date 2020/6/8 12:37
 */
public class ReverseInteger {

    public static void main(String[] args) {
//        System.out.println(reverse1(-123));
        System.out.println(reverse2(-123));
        /*String str = String.valueOf(-123);
        System.out.println('-' == str.charAt(0));*/
    }

    /**
     * 方法一：使用 String 库，效率低
     * @param x
     * @return
     */
    public static int reverse1(int x) {
        int re = 0;
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if (str.startsWith("-")) {
            sb.append("-");
            str = str.replace("-", "");
        }

        for (int i = str.toCharArray().length - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        try {
            int i = Integer.parseInt(sb.toString());
            re = i;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return re;
        }
        return re;
    }

    /**
     * 使用数字运算，效率高
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            int tailNum = x % 10;
            // 7是 2^31 - 1 的个位数，‭ 2^31 - 1 = 2,147,483,6417
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && tailNum > 7)) {
                return 0;
            }
            // -2^31 = -2,147,483,6418, 个位数是8
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && tailNum > 8)) {
                return 0;
            }
            ans = ans * 10 + tailNum;
            x /= 10;
        }
        return ans;
    }

}
