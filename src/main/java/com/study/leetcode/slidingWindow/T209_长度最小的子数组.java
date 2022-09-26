package com.study.leetcode.slidingWindow;

/**
 * @author c
 * 2022/7/27
 */
public class T209_长度最小的子数组 {

    public static int minSubArrayLen(int target, int[] nums) {
        // 初始化 left，right，result，bestResult
        // result是当前的currSum、bestResult为mixLength
        int left = 0, right = 0,currSum = 0, mixLength = 0;
        // 右指针没有到结尾
        while(right < nums.length){
            // 窗口扩大，加入right对应元素，更新当前
            currSum += nums[right];
            // result满足要求
            while(currSum >= target){
                // 更新最优结果mixLength
                if(right - left + 1 < mixLength || mixLength == 0){
                    mixLength = right - left + 1;
                }
                // 窗口缩小，移除left对应元素，left右移
                currSum = currSum - nums[left];
                left++;
            }
            // right++
            right++;
        }
        // 返回mixLength
        return mixLength;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        minSubArrayLen(target,nums);
    }

}
