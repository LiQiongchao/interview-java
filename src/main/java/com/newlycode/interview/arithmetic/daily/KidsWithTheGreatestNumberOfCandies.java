package com.newlycode.interview.arithmetic.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【简单】拥有最多糖果的孩子
 * candies：指针为孩子名，canndies[i]里面为拥有的糖数，
 * extraCandies：是额外的糖数
 *  把所有的额外糖果分给candies的某个孩子，他能成为拥有最多糖果的孩子，就为true，否则为false
 * @author Liqc
 * @date 2020/6/1 13:29
 */
public class KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>(candies.length + 1);
        int maxCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            list.add(candies[i] + extraCandies >= maxCandies);
        }
        return list;
    }

}
