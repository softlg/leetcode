package com.study.leetcode.September;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：c
 * Date：2022/9/23
 */
public class T454_四数相加II {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：

        0 <= i, j, k, l < n
        nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

    --------------------------------------------------------------------------------
    解题思路：
        用哈希 时间复杂度O(n^2)

        本题解题步骤：
            1、首先定义 一个map，key放a和b两数之和，value 放a和b两数之和出现的次数。
            2、遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
            3、定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
            4、在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
            5、最后返回统计值 count 就可以了
    --------------------------------------------------------------------------------
     */

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int temp;
        Map<Integer,Integer> map = new HashMap<>(nums1.length);
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                temp = nums1[i] + nums2[j];
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp) + 1);
                }else {
                    map.put(temp, 1);
                }
            }
        }
        System.out.println(map);
        int result = 0;
        for(int i = 0; i < nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){
                temp = nums3[i] + nums4[j];
                if(map.containsKey(-temp)){
                    result += map.get(0 - temp);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        int[] nums1 = {-1,-1}, nums2 = {-1,1}, nums3 = {-1,1}, nums4 = {1,-1};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
