package com.newlycode.interview.arithmetic.top100;

/**
 * 【困难】寻找两个正序数组的中位数
 *  找出两个数组中的中位数，
 *  如：
 *      {1，3}，{2}，中位数为2
 *      {1，2}，{3，4}，中位数为 (2+3)/2 = 2.5
 *  要求时间复杂度为：O(log(m+n))
 *
 *  解法：
 *  使用二分查找算法，假设两个数组中有一个分隔线，分隔线即为中位点分隔线，（当为奇数时，分隔线在中间元素的右边）
 *  如： [1] [4] | [6] [8]
 *       [2] [3] [5] | [7]
 *  图中 “|” 即为分隔线。分隔线左边的元素会小于右边的元素，无论在上面还是在下面。（因为递增）
 *
 * @author Liqc
 * @date 2020/6/1 13:17
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 尽量使第二个数组为最大的数组
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length, n = nums2.length;
        int totalLeft = (m + n + 1)/2;
        int left = 0, right = m;

        // 二分查找，查找出在第一个数组中 “红线的位置”
        while (left < right) {
            /*
            第一个数组的指针，确定第一个数组的指针就可以通过计算出来第二个数组的指针。
            nums1[i-1] < nums2[j] || nums2[j - 1] < nums1[i]
            此处要求第一个数组中分割线的左边的值 不大于(小于等于) 第二个数组中分割线的右边的值
            此处要求第二个数组中分割线的左边的值 不大于(小于等于) 第一个数组中分割线的右边的值
             */

            // 防止溢出可以写成 left + (right - left + 1) / 2;
            int i = (right + left + 1)/2;
            // 第二个数组的指针
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        // 防止极端情况的发生，比如红线会在数组的左边或者右边
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if ((m + n) % 2 == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        }
    }
}
