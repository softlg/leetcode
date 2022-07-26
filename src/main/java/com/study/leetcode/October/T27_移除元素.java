package com.study.leetcode.October;

/**
 * @author c
 * @date 2022/10/8 23:31
 */
public class T27_移除元素 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

        不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0; fast <= nums.length - 1; fast++){
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
