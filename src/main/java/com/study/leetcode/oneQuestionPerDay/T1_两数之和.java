package com.study.leetcode.oneQuestionPerDay;

/**
 * @author c
 * 2023-7-1 09:52:17
 */
public class T1_两数之和 {
     /*
     难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

        你可以按任意顺序返回答案。
    --------------------------------------------------------------------------------

    解题思路：

    --------------------------------------------------------------------------------
     */

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {0,4,3,0};
        System.out.println(twoSum(nums, 0));
    }

}
