package com.study.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author c
 * @date 2023/3/17 21:58
 */
public class T剑指Offer03_数组中重复的数字 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        找出数组中重复的数字。

        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
        但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
