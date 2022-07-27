package com.study.leetcode.july;

import java.util.Arrays;

public class T724_寻找数组的中心下标 {

    /**
     * 寻找数组的中心下标（前缀和）
     * @param nums
     */
    public static int pivotIndex(int[] nums) {
        int sumLeft = 0, sumRight = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            sumRight -= nums[i];
            // 若左侧元素和等于右侧元素和，返回中心下标 i
            if (sumLeft == sumRight){
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

}
