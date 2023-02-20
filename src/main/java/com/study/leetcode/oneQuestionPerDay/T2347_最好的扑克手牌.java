package com.study.leetcode.oneQuestionPerDay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author c
 * @date 2023/2/20 23:17
 */
public class T2347_最好的扑克手牌 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。

        下述是从好到坏你可能持有的 手牌类型 ：

        "Flush"：同花，五张相同花色的扑克牌。
        "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
        "Pair"：对子，两张大小一样的扑克牌。
        "High Card"：高牌，五张大小互不相同的扑克牌。
        请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。

        注意：返回的字符串 大小写 需与题目描述相同。

        链接：https://leetcode.cn/problems/best-poker-hand
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    /**
     * 解法一
     * @param ranks
     * @param suits
     * @return
     */
    public static String bestHand2(int[] ranks, char[] suits){
        boolean flush = true;
        for (int i = 1; i < 5 && flush; ++i) {
            flush = suits[i] == suits[i - 1];
        }
        if (flush) {
            return "Flush";
        }
        int[] cnt = new int[14];
        boolean pair = false;
        for (int x : ranks) {
            if (++cnt[x] == 3) {
                return "Three of a Kind";
            }
            pair = pair || cnt[x] == 2;
        }
        return pair ? "Pair" : "High Card";
    }

}
