package com.study.leetcode.shuati;

/**
 * @author c
 * @date 2023/2/2 21:58
 */
public class T7_整数反转 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

        如果反转后整数超过 32 位的有符号整数的范围 [−23^1,  23^1 − 1] ，就返回 0。

        假设环境不允许存储 64 位整数（有符号或无符号）。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/reverse-integer
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static int reverse(int x) {
        int rs = 0;
        while(x != 0){
            // 临界处理
            if (rs < Integer.MIN_VALUE / 10 || rs > Integer.MAX_VALUE / 10){
                return 0;
            }
            //
            int temp = x % 10;
            x /= 10;
            rs = rs * 10 + temp;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
