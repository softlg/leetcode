package com.study.leetcode.November;

/**
 * @author c
 * @date 2022/11/6 16:54
 */
public class T1470_重新排列数组 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。

        请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/shuffle-the-array
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }
}
