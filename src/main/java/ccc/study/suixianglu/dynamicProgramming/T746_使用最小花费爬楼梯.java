package ccc.study.suixianglu.dynamicProgramming;

/**
 * @author c
 * @date 2023/3/26 21:26
 */
public class T746_使用最小花费爬楼梯 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。

        你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。

        请你计算并返回达到楼梯顶部的最低花费。

        链接：https://leetcode.cn/problems/min-cost-climbing-stairs
    --------------------------------------------------------------------------------
    解题思路：
        动态规划
    --------------------------------------------------------------------------------
     */

    public int minCostClimbingStairs(int[] cost) {
        // 到达第i台阶所花费的最少体力为dp[i]。
        int[] dp = new int[cost.length + 1];
        // 初始化
        dp[0] = 0;
        dp[1] = 0;
        //遍历
        for(int i = 2; i <= cost.length; i++){
            // 递归公式
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
