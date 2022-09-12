package com.study.leetcode.September;
/**
 * @author：c
 * Date：2022/9/12
 */
public class T209_长度最小的子数组 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给定一个含有 n 个正整数的数组和一个正整数 target 。

        找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
        并返回其长度。如果不存在符合条件的子数组，返回 0 。

    --------------------------------------------------------------------------------
    解题思路：
        双指针 滑动窗口
    --------------------------------------------------------------------------------
     */

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= target){
                result = Math.min(result,i - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] s = {2,3,1,2,4,3};
        minSubArrayLen(target, s);
    }
}
