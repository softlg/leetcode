package com.study.leetcode.August;
/**
 * @author c
 * 2022/8/4
 */
public class T509_斐波那契数 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和

    --------------------------------------------------------------------------------
    解题思路：


    --------------------------------------------------------------------------------
     */

    public int fib(int n) {
        // 临界条件
        if(n < 2){
            return n;
        }
        // 递归
        return fib(n - 1) + fib(n - 2);
    }
}
