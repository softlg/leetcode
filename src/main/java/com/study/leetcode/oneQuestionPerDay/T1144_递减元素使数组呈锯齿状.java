package com.study.leetcode.oneQuestionPerDay;

/**
 * @author c
 * @date 2023/2/27 23:47
 */
public class T1144_递减元素使数组呈锯齿状 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。

        如果符合下列情况之一，则数组 A 就是 锯齿数组：

        每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
        或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
        返回将数组 nums 转换为锯齿数组所需的最小操作次数。

        链接：https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int movesToMakeZigzag(int[] nums) {
        int[] s = new int[2];
        for (int i = 0, n = nums.length; i < n; ++i) {
            int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i < n - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            s[i % 2] += Math.max(nums[i] - Math.min(left, right) + 1, 0);
        }
        return Math.min(s[0], s[1]);
    }
}
