package com.study.leetcode.oneQuestionPerDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author c
 * 2022/8/4
 */
public class T1403_非递增顺序的最小子序列 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。

        如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。

        与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。

        注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列

    --------------------------------------------------------------------------------
    解题思路：          贪心

        对数组进行排序，然后计算出总和sum，为了保证数字个数最少，每次都取最大的元素放入答案，判断ans的和是否大于剩余即可。

    --------------------------------------------------------------------------------
     */

    public static List<Integer> minSubsequence(int[] nums) {
        // 累加结果集
        List<Integer> res = new ArrayList<>(nums.length);
        // 排序
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            // 累加
            sum += num;
            res.add(num);
        }
        // 收集下标的集合
        List<Integer> result = new ArrayList<>(nums.length);
        // 末尾数相加结果集
        int resultSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            resultSum += nums[i];
            sum -= nums[i];
            result.add(nums[i]);
            if(resultSum > sum){
                break;
            }
        }
        return result;
    }


    public static List<Integer> minSubsequence2(int[] nums){
        // 排序
        Arrays.sort(nums);
        //总和
        int sum = Arrays.stream(nums).sum();
        List<Integer> ans = new ArrayList<>();
        //当前和
        int curSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            //加入答案
            curSum += nums[i];
            sum -= nums[i];
            ans.add(nums[i]);
            //判断当前元素和是否大于剩余的和
            if (curSum > sum) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,10,9,8};
        // test
        minSubsequence(nums);
    }
}
