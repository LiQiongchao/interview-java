package com.newlycode.interview.arithmetic.top100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 【中等】5. 最长回文子串
 *  回文串（palindromic string）是指这个字符串无论从左读还是从右读，所读的顺序是一样的；简而言之，回文串是左右对称的。
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Liqc
 * @date 2020/6/4 12:44
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = maxPalindrome(s, i, i);
            int len2 = maxPalindrome(s, i, i+1);
            int max = Math.max(len1, len2);
            if (max > end - start + 1) {
                // 计算这次的前后指针的位置
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 计算从begin, end开始向两边扩展在s中的最大回文子串
     * @param s
     * @param begin
     * @param end
     * @return
     */
    public static int maxPalindrome(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return end - begin - 1;
    }
}
