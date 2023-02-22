package ccc.study.suixianglu.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/21 23:58
 */
public class T509_斐波那契数 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

        F(0) = 0，F(1) = 1
        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
        给定 n ，请计算 F(n) 。

        链接：https://leetcode.cn/problems/fibonacci-number
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    /**
     * 解法一：递归
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n < 2){
            return n;
        }
        return fib(n - 1) + fib(n -2);
    }

    /**
     * 同城笔试
     * @param n
     * @return
     */
    public static long fibLong(long n) {
        if(n < 2L){
            return n;
        }

        return fibLong(Long.valueOf(n - 1)) + fibLong(Long.valueOf(n - 2));
    }

    public static long[] test(long sum){
        List<Long> res = new ArrayList<>(2);
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            long after = fibLong(i) * fibLong(i + 1);
            if (after == sum){
                res.add(fibLong(i));
                res.add(fibLong(i + 1));
                res.add(1L);
                break;
            }else if (after > sum){
                res.add(fibLong(i - 1));
                res.add(fibLong(i));
                res.add(0L);
                break;
            }
        }
        return res.stream().mapToLong(Long::intValue).toArray();
    }


    public static void main(String[] args) {
        System.out.println(test(800L));
    }
}
