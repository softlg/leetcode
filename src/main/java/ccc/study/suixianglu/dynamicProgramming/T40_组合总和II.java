package ccc.study.suixianglu.dynamicProgramming;

/**
 * @author c
 * @date 2023-8-29 15:49:39
 */
public class T40_组合总和II {
     /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。

        题目数据保证答案符合 32 位整数范围。
    --------------------------------------------------------------------------------
    解题思路：
        如果求组合数就是外层for循环遍历物品，内层for遍历背包。
        如果求排列数就是外层for遍历背包，内层for循环遍历物品。
    --------------------------------------------------------------------------------
     */

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 初始化
        dp[0] = 1;
        // 遍历背包
        for(int i = 0; i <= target; i++){
            // 遍历物品
            for(int j = 0; j < nums.length; j++){
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
