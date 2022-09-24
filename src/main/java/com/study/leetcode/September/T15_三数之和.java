package com.study.leetcode.September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author c
 * @date 2022/9/24 13:44
 */
public class T15_三数之和 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
        同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

        你返回所有和为 0 且不重复的三元组。

        注意：答案中不可以包含重复的三元组。

    --------------------------------------------------------------------------------
    解题思路：
        首先将数组排序，然后有一层for循环，i从下标0的地方开始，同时定一个下标left 定义在i+1的位置上，定义下标right 在数组结尾的位置上。

        依然还是在数组中找到 abc 使得a + b +c =0，我们这里相当于 a = nums[i]，b = nums[left]，c = nums[right]。

        接下来如何移动left 和right呢， 如果nums[i] + nums[left] + nums[right] > 0 就说明 此时三数之和大了，因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些。

        如果 nums[i] + nums[left] + nums[right] < 0 说明 此时 三数之和小了，left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。

        时间复杂度：O(n^2)。
    --------------------------------------------------------------------------------
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        // 存放结果数组集
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 遍历
        for(int i = 0; i < nums.length; i++){
            // 临界判断
            if(nums[i] > 0){
                return result;
            }
            // 对i去重
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 定义两指针
            int left = i + 1;
            int right = nums.length - 1;
            // 终止条件
            while(right > left){
                // 指针移动
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(right > left && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(right > left && nums[right] == nums[right - 1]){
                        right--;
                    }
                    right--;
                    left++;
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

}
