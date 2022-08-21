package com.study.leetcode.oneQuestionPerDay;
/**
 * @author c
 * 2022/8/21
 */
public class T1455_检查单词是否为句中其他单词的前缀 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。

        如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。

        字符串 s 的 前缀 是 s 的任何前导连续子字符串。

    --------------------------------------------------------------------------------
    解题思路：


    --------------------------------------------------------------------------------
     */

    public int isPrefixOfWord(String s, String t) {
        String[] ss = s.split(" ");
        int n = ss.length, m = t.length();
        for (int i = 0; i < n; i++) {
            if (ss[i].length() < m) {
                continue;
            }
            boolean ok = true;
            for (int j = 0; j < m && ok; j++) {
                if (ss[i].charAt(j) != t.charAt(j)) {
                    ok = false;
                }
            }
            if (ok) {
                return i + 1;
            }
        }
        return -1;
    }


}
