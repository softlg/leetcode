package com.study.leetcode.September;

import java.util.HashSet;
import java.util.Set;

/**
 * @author c
 * @date 2022/9/24 15:28
 */
public class T219_存在重复元素II {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
        满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。

    --------------------------------------------------------------------------------
    解题思路：
        标签：哈希
        维护一个哈希表，里面始终最多包含 k 个元素，当出现重复值时则说明在 k 距离内存在重复元素
        每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字
        时间复杂度：O(n)O(n)，nn 为数组长度
    --------------------------------------------------------------------------------
     */

    /**
     * 解法一：双指针
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int i = 0, j = 3;
//        System.out.println(Math.abs(i - j));
        int[] nums = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }
}
