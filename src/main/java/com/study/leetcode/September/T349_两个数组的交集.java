package com.study.leetcode.September;

import java.util.HashSet;
import java.util.Set;

/**
 * @author：c
 * Date：2022/9/21
 */
public class T349_两个数组的交集 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        // 临界条件判断
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        // 遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        // 遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        // 将结果几何转为数组
        return resSet.stream().mapToInt(x -> x).toArray();
    }
}
