package com.study.leetcode.September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author c
 * @date 2022/9/24 14:25
 */
public class T18_四数之和 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 
        [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

                0 <= a, b, c, d < n
                a、b、c 和 d 互不相同
                nums[a] + nums[b] + nums[c] + nums[d] == target
                你可以按 任意顺序 返回答案 。

    --------------------------------------------------------------------------------
    解题思路：
        四数之和，和15.三数之和 (opens new window)是一个思路，都是使用双指针法, 基本解法就是在15.三数之和 (opens new window)的基础上再套一层for循环。

        但是有一些细节需要注意，例如： 不要判断nums[k] > target 就返回了，三数之和 可以通过 nums[i] > 0 就返回了，因为 0 已经是确定的数了，四数之和这道题目 target是任意值。比如：数组是[-4, -3, -2, -1]，target是-10，不能因为-4 > -10而跳过。但是我们依旧可以去做剪枝，逻辑变成nums[i] > target && (nums[i] >=0 || target >= 0)就可以了。

        15.三数之和 (opens new window)的双指针解法是一层for循环num[i]为确定值，然后循环内有left和right下标作为双指针，找到nums[i] + nums[left] + nums[right] == 0。

        四数之和的双指针解法是两层for循环nums[k] + nums[i]为确定值，依然是循环内有left和right下标作为双指针，找出nums[k] + nums[i] + nums[left] + nums[right] == target的情况，三数之和的时间复杂度是O(n^2)，四数之和的时间复杂度是O(n^3) 。

        那么一样的道理，五数之和、六数之和等等都采用这种解法。

        对于15.三数之和 (opens new window)双指针法就是将原本暴力O(n^3)的解法，降为O(n^2)的解法，四数之和的双指针解法就是将原本暴力O(n^4)的解法，降为O(n^3)的解法。

        之前我们讲过哈希表的经典题目：454.四数相加II (opens new window)，相对于本题简单很多，因为本题是要求在一个集合中找出四个数相加等于target，同时四元组不能重复。

        而454.四数相加II (opens new window)是四个独立的数组，只要找到A[i] + B[j] + C[k] + D[l] = 0就可以，不用考虑有重复的四个元素相加等于0的情况，所以相对于本题还是简单了不少！
    --------------------------------------------------------------------------------
     */

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        //
        for (int i = 0; i < nums.length; i++) {
            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                // 定义双指针
                int left = j + 1;
                int right = nums.length - 1;
                //
                while(right > left){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target){
                        right--;
                    }else if(sum < target){
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(right > left && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(right > left && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums,0));
    }
}