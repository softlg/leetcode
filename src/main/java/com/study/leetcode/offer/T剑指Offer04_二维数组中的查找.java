package com.study.leetcode.offer;

/**
 * @author c
 * @date 2023/3/17 20:27
 */
public class T剑指Offer04_二维数组中的查找 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，
        每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，
        输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
    --------------------------------------------------------------------------------
    解题思路：
        从左下角开始二分查找
    --------------------------------------------------------------------------------
     */

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(arr,5));
    }

}
