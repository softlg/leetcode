package ccc.study.suixianglu.dynamicProgramming;

/**
 * @author c
 * @date 2023/3/24 22:51
 */
public class T70_爬楼梯 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

    --------------------------------------------------------------------------------
    解题思路：
        动态规划 递归
    --------------------------------------------------------------------------------
     */

    public int climbStairs(int n) {
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int climbStairs2(int n) {
        int num = 2;
        //
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 先遍历背包，再遍历物品
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= num; j++){
                if(i >= j){
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
