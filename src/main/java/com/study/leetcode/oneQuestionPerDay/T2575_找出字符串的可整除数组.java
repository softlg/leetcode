package com.study.leetcode.oneQuestionPerDay;

public class T2575_找出字符串的可整除数组 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。

        word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：

        如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
        否则，div[i] = 0
        返回 word 的可整除数组。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int[] divisibilityArray(String word, int m) {
        char[] s = word.toCharArray();
        int[] ans = new int[s.length];
        long x = 0;
        for (int i = 0; i < s.length; i++) {
            x = (x * 10 + (s[i] - '0')) % m;
            if (x == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

}
