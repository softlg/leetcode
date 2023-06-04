package com.study.leetcode.oneQuestionPerDay;

import java.util.*;

/**
 * @author c
 * @date 2023/6/4
 */
public class T2465_不同的平均值数目 {
     /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
       https://leetcode.cn/problems/number-of-distinct-averages/
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static int distinctAverages(int[] nums) {
        Set<Double> res = new HashSet<>();
        // 排序
        Arrays.sort(nums);
        // 遍历
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            double average = (double) (nums[i] + nums[nums.length - 1 - i]) / 2;
            res.add(average);
        }
        return res.size();
    }

    public static void main(String[] args) {
        int[] nums = {9,5,7,8,7,9,8,2,0,7};
        System.out.println(distinctAverages(nums));
    }
}
