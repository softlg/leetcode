package com.study.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author c
 * @date 2023/3/17 21:51
 */
public class T剑指Offer50_第一个只出现一次的字符 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for(char c : sc) {
            if(dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
