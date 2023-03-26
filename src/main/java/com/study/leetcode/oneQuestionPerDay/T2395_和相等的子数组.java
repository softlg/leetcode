package com.study.leetcode.oneQuestionPerDay;

/**
 * @author c
 * @date 2023/3/26 21:05
 */
public class T2395_和相等的子数组 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个下标从 0 开始的整数数组 nums ，判断是否存在 两个 长度为 2 的子数组且它们的 和 相等。注意，这两个子数组起始位置的下标必须 不相同 。

        如果这样的子数组存在，请返回 true，否则返回 false 。

        子数组 是一个数组中一段连续非空的元素组成的序列。

        链接：https://leetcode.cn/problems/find-subarrays-with-equal-sum
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static boolean findSubarrays(int[] nums) {
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j <= nums.length - 2; j++){
                if(nums[i] + nums[i + 1] == nums[j] + nums[j + 1]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,4};
        System.out.println(findSubarrays(nums));
    }

}
