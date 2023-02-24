package com.study.leetcode.oneQuestionPerDay;

/**
 * @author c
 * @date 2023/2/24 21:53
 */
public class T2357_使数组中所有元素都等于零 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个非负整数数组 nums 。在一步操作中，你必须：

        选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
        nums 中的每个正整数都减去 x。
        返回使 nums 中所有元素都等于 0 需要的 最少 操作数。

        链接：https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts
    --------------------------------------------------------------------------------
    解题思路：
        哈希
    --------------------------------------------------------------------------------
     */

    public int minimumOperations(int[] nums) {
        boolean[] s = new boolean[101];
        s[0] = true;
        int ans = 0;
        for (int x : nums) {
            if (!s[x]) {
                ++ans;
                s[x] = true;
            }
        }
        return ans;
    }
}
