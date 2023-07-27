package com.study.leetcode.oneQuestionPerDay;

import java.util.Arrays;

public class T2500_删除每行中的最大值 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。

        执行下述操作，直到 grid 变为空矩阵：

        从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
        将删除元素中的最大值与答案相加。
        注意 每执行一次操作，矩阵中列的数据就会减 1 。

        返回执行上述操作后的答案。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int deleteGreatestValue(int[][] grid) {
        int result = 0;
        // 每行排序
        for(int i = 0; i < grid.length; i++){
            Arrays.sort(grid[i]);
        }
        // 每次取最后一列中最大值
        for (int j = 0; j < grid[0].length; ++j) {
            int t = 0;
            for (int i = 0; i < grid.length; ++i) {
                t = Math.max(t, grid[i][j]);
            }
            result += t;
        }
        return result;
    }



}
