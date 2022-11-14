package com.study.leetcode.oneQuestionPerDay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author c
 * @date 2022/11/14 18:50
 */
public class T805_数组的均值分割 {
    /*
    难度：困难
    --------------------------------------------------------------------------------
    题目：
        给定你一个整数数组 nums

        我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == average(B) 。

        如果可以完成则返回true ， 否则返回 false  。

        注意：对于数组 arr ,  average(arr) 是 arr 的所有元素的和除以 arr 长度。

         

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/split-array-with-same-average
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        int s = Arrays.stream(nums).sum();
        for (int i = 0; i < n; ++i) {
            nums[i] = nums[i] * n - s;
        }
        int m = n >> 1;
        Set<Integer> vis = new HashSet<>();
        for (int i = 1; i < 1 << m; ++i) {
            int t = 0;
            for (int j = 0; j < m; ++j) {
                if (((i >> j) & 1) == 1) {
                    t += nums[j];
                }
            }
            if (t == 0) {
                return true;
            }
            vis.add(t);
        }
        for (int i = 1; i < 1 << (n - m); ++i) {
            int t = 0;
            for (int j = 0; j < (n - m); ++j) {
                if (((i >> j) & 1) == 1) {
                    t += nums[m + j];
                }
            }
            if (t == 0 || (i != (1 << (n - m)) - 1) && vis.contains(-t)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(splitArraySameAverage(nums));
    }
}
