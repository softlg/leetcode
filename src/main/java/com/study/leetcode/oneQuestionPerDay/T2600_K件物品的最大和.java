package com.study.leetcode.oneQuestionPerDay;

public class T2600_K件物品的最大和 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
        给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
        袋子最初包含：
            numOnes 件标记为 1 的物品。
            numZeroes 件标记为 0 的物品。
            numNegOnes 件标记为 -1 的物品。
            现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
    --------------------------------------------------------------------------------
    解题思路：
        方法一：贪心

        根据题目描述，应该尽可能多地取标记为 111 的物品，然后取标记为 000 的物品，最后取标记为 −1-1−1 的物品。

    --------------------------------------------------------------------------------
     */

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            return k;
        }
        if (numZeros >= k - numOnes) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }
}
