package com.study.leetcode.oneQuestionPerDay;

/**
 * @author c
 * @date 2023/2/26 22:22
 */
public class T1255_得分最高的单词集合 {
    /*
    难度：hard
    --------------------------------------------------------------------------------
    题目：
        你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。

        请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。

        单词拼写游戏的规则概述如下：

        玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
        可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
        单词表 words 中每个单词只能计分（使用）一次。
        根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
        本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。

        链接：https://leetcode.cn/problems/maximum-score-words-formed-by-letters
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    private String[] words;
    private int[] score;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        int[] left = new int[26];
        for (char c : letters) {
            ++left[c - 'a'];
        }
        return dfs(words.length - 1, left);
    }

    private int dfs(int i, int[] left) {
        // base case
        if (i < 0) {
            return 0;
        }

        // 不选 words[i]
        int res = dfs(i - 1, left);

        // 选 words[i]
        int[] tmp = left.clone();
        int s = 0;
        for (char c : words[i].toCharArray()) {
            // 剩余字母不足
            if (tmp[c - 'a']-- == 0) {
                return res;
            }
            // 累加得分
            s += score[c - 'a'];
        }
        return Math.max(res, s + dfs(i - 1, tmp));
    }
}
