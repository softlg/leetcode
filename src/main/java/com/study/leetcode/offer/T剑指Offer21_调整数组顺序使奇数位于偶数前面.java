package com.study.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author c
 * @date 2023/3/25 22:46
 */
public class T剑指Offer21_调整数组顺序使奇数位于偶数前面 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int[] exchange(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0){
                res.add(nums[i]);
            }else{
                temp.add(nums[i]);
            }
        }
        for(int i : temp){
            res.add(i);
        }
        int[] resArr = new int[nums.length];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

}
