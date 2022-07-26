package com.study.leetcode.November;

/**
 * @author c
 * @date 2022/11/13 23:04
 */
public class T724_寻找数组的中心下标 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums ，请计算数组的 中心下标 。

        数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。

        如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。

        如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/find-pivot-index
    --------------------------------------------------------------------------------
    解题思路：
            首先计算总和，再计算左边总和，如果数组总和等于左边总和的两倍，说明左右相等
    --------------------------------------------------------------------------------
     */

    public int pivotIndex(int[] nums) {
        // 首先计算总和
        int sum = 0;
        for(int i = 0; i < nums.length;i++){
            sum += nums[i];
        }
        // 再计算左边总和，如果数组总和等于左边总和的两倍，说明左右相等
        int sumL = 0;
        for(int i = 0;i < nums.length;i++){
            sum -= nums[i];
            if(sum == sumL){
                return i;
            }
            sumL += nums[i];
        }
        return -1;

    }
}
