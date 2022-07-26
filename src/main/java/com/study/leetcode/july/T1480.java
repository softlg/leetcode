package com.study.leetcode.july;

public class T1480 {

    /**
     * 方法一
     * @param nums 参数
     */
    public static int[] runningSum(int[] nums) {
        // 定义一个结果数组
        int[] res = new int[nums.length];
        // 遍历数组
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <= i; j++){
                // 注意是 res[i]  否则得到的结果是反的
                res[i] += nums[j];
            }
        }
        // 返回
        return res;
    }

    /**
     * 方法二
     * @param nums 参数
     */
    public static int[] runningSumTwo(int[] nums) {
        int length = nums.length;
        int[] sums = new int[length];
        sums[0] = nums[0];
        for (int i = 1; i < length; i++) {
            //
            sums[i] = sums[i - 1] + nums[i];
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(runningSum(nums));
        System.out.println(runningSumTwo(nums));
    }



}
