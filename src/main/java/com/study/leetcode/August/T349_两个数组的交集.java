package com.study.leetcode.August;

import java.util.*;

/**
 * @author c
 * 2022/8/3
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

    /**
     *  方法一
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs=new HashSet<Integer>();

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    hs.add(nums1[i]);
                }
            }
        }

        Integer[] temp=hs.toArray(new Integer[]{});

        int[] intArray=new int[temp.length];

        for(int i=0;i<temp.length;i++){
            intArray[i]=temp[i].intValue();
        }
        return intArray;
    }

    /**
     * 解法二 排序后双指针
     */
    public int[] intersection2(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, m = a.length, n = b.length;
        while(i < m && j < n){
            if(a[i] == b[j]){
                while(i+1<m && a[i+1] == a[i]){
                    i++;
                }
                list.add(a[i++]);
            }else if(a[i] < b[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] ans = new int[list.size()];
        for(int i1 = 0;i1 < list.size();i1++){
            ans[i1] = list.get(i1);
        }
        return ans;
    }
}
