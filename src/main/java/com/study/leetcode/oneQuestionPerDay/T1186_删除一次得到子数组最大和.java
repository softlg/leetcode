package com.study.leetcode.oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author c
 * @date 2023-6-27 18:44:52
 */
public class T1186_删除一次得到子数组最大和 {
     /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
       给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，
       你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，
       然后该子数组（剩下）的元素总和是所有子数组之中最大的。

        注意，删除一个元素后，子数组 不能为空。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    private int[] arr;
    private int[][] memo;

    public int maximumSum(int[] arr) {
        this.arr = arr;
        int ans = Integer.MIN_VALUE, n = arr.length;
        memo = new int[n][2];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, Math.max(dfs(i, 0), dfs(i, 1)));
        return ans;
    }

    private int dfs(int i, int j) {
        if (i < 0) return Integer.MIN_VALUE / 2; // 除 2 防止负数相加溢出
        if (memo[i][j] != Integer.MIN_VALUE) return memo[i][j]; // 之前计算过
        if (j == 0) return memo[i][j] = Math.max(dfs(i - 1, 0), 0) + arr[i];
        return memo[i][j] = Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
    }

}
