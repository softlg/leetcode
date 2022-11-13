package com.study.leetcode.November;

/**
 * @author c
 * @date 2022/11/13 22:56
 */
public class T1480_一维数组的动态和 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

        请返回 nums 的动态和。

    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length <= 1){
            return nums;
        }
        int curSum = 0;
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            res[i] = curSum;
        }
        return res;
    }
}
