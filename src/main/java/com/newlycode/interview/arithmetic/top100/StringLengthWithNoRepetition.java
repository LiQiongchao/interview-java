package com.newlycode.interview.arithmetic.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 求字符串中不重复的字符串的最大长度
 * 利用滑动窗口，时间复杂度O(n)
 * 滑动窗口：
 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，
 * 这时候不满足要求。所以，我们要移动这个队列！
 *
 * 如何移动？
 *
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
 * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
 *
 * 作者：powcai
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author Liqc
 * @date 2020/6/1 12:50
 */
public class StringLengthWithNoRepetition {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdccdeade"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 相当于滑动窗口的队列
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 如果队列中已经存在这个字符，说明达到这段的最大长度，向右移动左侧指针，排除第一个该字符左边的所有字符
                left = Math.max(left, map.get(c) + 1);
            }
            max = Math.max(max, i - left + 1);
            map.put(c, i);
        }
        return max;
    }
}
