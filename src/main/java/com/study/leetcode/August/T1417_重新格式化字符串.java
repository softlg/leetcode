package com.study.leetcode.August;
/**
 * @author c
 * @date 2022/8/11 13:56
 */
public class T1417_重新格式化字符串 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。

        请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。

        请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
    --------------------------------------------------------------------------------
    解题思路：
        起始先对字符串 s 进行遍历，将其分成字母串和数字串，若两者长度差值超过 11，说明无法构造成间隔字符串（返回空串），
        否则对两字符串使用双指针算法进行构造。
    --------------------------------------------------------------------------------
     */

    public String reformat(String s) {
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                a.append(c);
            } else {
                b.append(c);
            }
        }
        int n = a.length(), m = b.length(), tot = n + m;
        if (Math.abs(n - m) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() != tot) {
            if (n > m) {
                sb.append(a.charAt(--n));
            } else if (n < m) {
                sb.append(b.charAt(--m));
            } else {
                if (!sb.isEmpty() && sb.charAt(sb.length() - 1) >= 'a') {
                    sb.append(b.charAt(--m));
                } else {
                    sb.append(a.charAt(--n));
                }
            }
        }
        return sb.toString();
    }


}
