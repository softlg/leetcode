package com.study.leetcode.October;

/**
 * @author c
 * @date 2022/10/3 15:33
 */
public class T28_找出字符串中第一个匹配项的下标 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
        如果 needle 不是 haystack 的一部分，则返回  -1 。
    --------------------------------------------------------------------------------
    解题思路：
        KMP算法 前缀表
        getNext步骤：
            1：初始化
            2：前后缀不同情况处理
            3：前后缀相同情况处理
            4：更新next数组
    --------------------------------------------------------------------------------
     */

    /**
     * 前缀表（不减一）
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        // 临界判断
        if (needle.length() == 0){
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 匹配不成功 j = next[j - 1]
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)){
                j = next[j - 1];
            }
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (needle.charAt(j) == haystack.charAt(i)){
                j++;
            }
            // 整一段匹配成功，直接返回下标
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }

        }
        return -1;
    }

    public void getNext(int[] next,String needle){
        // 1、初始化
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            // 2：前后缀不同情况处理
            // 注意不是if （存在连续往前跳的情况）
            while(j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            // 3：前后缀相同情况处理
            if (needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }
}
