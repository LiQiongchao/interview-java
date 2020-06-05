package com.newlycode.interview.arithmetic.daily;

import java.util.Arrays;

/**
 * 【简单】面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Liqc
 * @date 2020/6/5 13:47
 */
public class ShunShiZhenDaYinJuZhen {

    public static void main(String[] args) {
        Arrays.stream(shunShiZhenDaYinJuZhen(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})).forEach(a -> System.out.print(a));
    }

    private static int[] shunShiZhenDaYinJuZhen(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, x = 0;
        int[] res = new int[matrix[0].length * matrix.length];
        while (true) {
            // left to right
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                res[x++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            // right to left
            for (int i = right; i >= left; i--) {
                res[x++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            // bottom to top
            for (int i = bottom; i >= top; i--) {
                res[x++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }

        return res;
    }

}
