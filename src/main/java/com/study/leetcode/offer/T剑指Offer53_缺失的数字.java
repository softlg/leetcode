package com.study.leetcode.offer;

/**
 * @author c
 * @date 2023/3/17 22:17
 */
public class T剑指Offer53_缺失的数字 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
        在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/que-shi-de-shu-zi-lcof
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int missingNumber(int[] nums) {
        // 临界
        if(nums.length == 1){
            return nums[0] > 0 ? nums[0] - 1 : nums[0] + 1;
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i + 1] - 1){
                return nums[i] + 1;
            }
        }
        return nums[0] == 0 ? nums[nums.length - 1] + 1 : 0;
    }
}
