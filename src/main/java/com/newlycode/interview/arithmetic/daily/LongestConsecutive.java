package com.newlycode.interview.arithmetic.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * 【困难】128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 解：
 *  1- 先把所有的数据放到Set中，一是去重，二是查询快。
 *  2- 再次循环数组，遍历，如果数字的前一个不存在，就开始累加查询，直到查询不到为止。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: LiQiongchao
 * @Date: 2020/6/6 14:47
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 1, 200, 2, 3, 4}));
    }

    public static int longestConsecutive(int[] nums) {
        // 把数组的数据放入set中，1是去重，2是查找的时候快，不用遍历。
        Set<Integer> numsSet = new HashSet<>(nums.length + 1);
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }
        //
        int longConse = 0;
        for (int num : nums) {
            if (!numsSet.contains(num - 1)) {
                // 如果数组中没有该数字的前一个数字，说明这是一个连续序数的开头数字
                // 记录当前数字
                int curNum = num;
                // 记录当前的最大连续个数
                int curConse = 1;
                while (numsSet.contains(curNum + 1)) {
                    curNum++;
                    curConse++;
                }
                longConse = Math.max(longConse, curConse);
            }
        }
        return longConse;
    }
}
