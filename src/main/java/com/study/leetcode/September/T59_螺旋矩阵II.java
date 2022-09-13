package com.study.leetcode.September;
/**
 * @author：c
 * Date：2022/9/13
 */
public class T59_螺旋矩阵II {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
       给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static int[][] generateMatrix(int n) {
        // 每次循环的开始点（start，start）
        int start = 0;
        // 控制循环次数
        int loop = 0;
        // 定义填充数字
        int count = 1;
        int[][] res = new int[n][n];
        int i,j;

        // 判断边界后，loop从1开始
        while(loop++ < n / 2){
            // 模拟上侧从左到右
            for(j = start; j < n - loop; j++){
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }
}
