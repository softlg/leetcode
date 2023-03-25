package com.study.leetcode.offer;

/**
 * @author c
 * @date 2023/3/25 22:54
 */
public class T剑指Offer57_和为s的两个数字 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        while(left <= right){
            if(nums[left] + nums[right] == target){
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            }else if(nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }

}
