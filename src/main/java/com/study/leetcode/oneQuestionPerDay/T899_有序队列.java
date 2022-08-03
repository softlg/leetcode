package com.study.leetcode.oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author c
 * 2022/8/3
 */
public class T899_有序队列 {

     /*
    难度：难
    --------------------------------------------------------------------------------
    题目：
        给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。

        返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。

    --------------------------------------------------------------------------------
    解题思路：
            最小表示法
    --------------------------------------------------------------------------------
     */

    public String orderlyQueue(String s, int _k) {
        char[] cs = s.toCharArray();
        if (_k == 1) {
            int i = 0, j = 1, k = 0, n = cs.length;
            while (i < n && j < n && k < n) {
                char a = cs[(i + k) % n], b = cs[(j + k) % n];
                if (a == b){
                    k++;
                }
                else {
                    if (a > b){
                        i += k + 1;
                    }else{
                        j += k + 1;
                    }
                    if (i == j){
                        i++;
                    }
                    k = 0;
                }
            }
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);
        } else {
            Arrays.sort(cs);
            return String.valueOf(cs);
        }
    }


}
