package ccc.study.suixianglu.greed;

/**
 * @author c
 * @date 2023/2/22 22:16
 */
public class T53_最大子数组和 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

        子数组 是数组中的一个连续部分。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int maxSubArray(int[] nums) {
        // 临界
        if(nums.length <= 1){
            return nums[0];
        }
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

}
