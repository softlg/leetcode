package com.study.leetcode.oneQuestionPerDay;

import java.util.*;

/**
 * @author c
 * @date 2023/3/23 20:20
 */
public class T1630_等差子数组 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        https://leetcode.cn/problems/arithmetic-subarrays/
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < l.length; i++){
            Integer[] temp = getNewArr(nums, l[i], r[i]);
            res.add(judge(temp));
        }
        return res;
    }

    public static Integer[] getNewArr(int[] nums, int start, int end){
        List<Integer> temp = new ArrayList<>();
        for(int i = start; i <= end; i++){
            temp.add(nums[i]);
        }

        return temp.toArray(new Integer[temp.size()]);
    }

    public static Boolean judge(Integer[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] - nums[i] != nums[1] - nums[0]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }
}
