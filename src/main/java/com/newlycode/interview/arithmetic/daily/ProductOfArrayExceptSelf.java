package com.newlycode.interview.arithmetic.daily;

/**
 * 【中等】238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。 
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 解题思路：
 *  - 一个数组记录i左侧在nums中所有数的乘积。
 *  - 然后再反序计算最后的结果。
 *  - 反序计算的时候用一个变量记录i右侧所有数的乘积。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Liqc
 * @date 2020/6/4 11:55
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    public static int[] productExceptSelf(int[] nums) {
        // 返回的数组
        int[] answers = new int[nums.length];
        // 第一位要为1，那样乘积其它数的时候才不会为0，才能是个正常值。
        answers[0] = 1;
        // 使answers数组的每个值都等于左边所有数组的乘积。
        for (int i = 1; i < nums.length; i++) {
            answers[i] = answers[i - 1] * nums[i - 1];
        }
        // 反序计算每个数组的值，并启示录 i + 1的值为record, record为i右侧数的乘积。
        int record = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            answers[i] = answers[i] * record;
            record = record * nums[i];
        }
        return answers;
    }

}
