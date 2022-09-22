package com.study.leetcode.September;

import java.util.HashSet;
import java.util.Set;

/**
 * @author：c
 * Date：2022/9/22
 */
public class T202_快乐数 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        编写一个算法来判断一个数 n 是不是快乐数。

        「快乐数」 定义为：

        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
        如果这个过程 结果为 1，那么这个数就是快乐数。
        如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 || !set.contains(n)){
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    public int getNextNumber(int n){
        int sum = 0;
        while(n > 0){
            int gw = n % 10;
            sum += gw * gw;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 19;
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        System.out.println(sum);
    }


}
