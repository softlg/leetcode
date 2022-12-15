package com.study.leetcode.oneQuestionPerDay;

/**
 * @author c
 * @date 2022/12/15 16:00
 */
public class T1945_字符串转化后的各位数字之和 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个由小写字母组成的字符串 s ，以及一个整数 k 。

        首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。

        例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：

        转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
        转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
        转换 #2：17 ➝ 1 + 7 ➝ 8
        返回执行上述操作后得到的结果整数。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/sum-of-digits-of-string-after-convert
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        s = sb.toString();
        while (k-- > 0) {
            int t = 0;
            for (char c : s.toCharArray()) {
                t += c - '0';
            }
            s = String.valueOf(t);
        }
        return Integer.parseInt(s);
    }
}
