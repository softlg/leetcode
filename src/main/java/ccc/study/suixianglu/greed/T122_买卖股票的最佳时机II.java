package ccc.study.suixianglu.greed;

/**
 * @author c
 * @date 2023/2/22 22:31
 */
public class T122_买卖股票的最佳时机II {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

        在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

        返回 你能获得的 最大 利润 。

        链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */


    public int maxProfit(int[] prices) {
        int count = 0;
        for(int i = 0; i < prices.length; i++){
            if(i == prices.length - 1){
                break;
            }
            count += prices[i] < prices[i + 1] ? prices[i + 1] - prices[i] : 0;
        }
        return count;
    }
}
