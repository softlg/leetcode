package ccc.study.suixianglu.dynamicProgramming;

/**
 * @author c
 * @date 2023/4/24 21:50
 */
public class T416_分割等和子集 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    --------------------------------------------------------------------------------
    解题思路：
        0-1背包 dp
    --------------------------------------------------------------------------------
     */

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        // target
        int target = sum / 2;
        // 初始化
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 0;
        // 遍历
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
