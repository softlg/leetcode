package ccc.study.suixianglu.dynamicProgramming;

/**
 * @author c
 * @date 2023/4/25 22:06
 */
public class T1049_最后一块石头的重量II {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。

        每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

        如果 x == y，那么两块石头都会被完全粉碎；
        如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
        最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。

        链接：https://leetcode.cn/problems/last-stone-weight-ii
    --------------------------------------------------------------------------------
    解题思路：
        1、求stones总和sum 除以2得到中间值target
        2、将stones理解为分成两边 A边是target的重量   B边是 sum - target的重量
        3、 最后用 B - A 得到最小重量
    --------------------------------------------------------------------------------
     */

    public int lastStoneWeightII(int[] stones) {
        // 初始化
        int[] dp = new int[1501];
        dp[0] = 0;
        dp[1] = 0;
        //
        int sum = 0;
        for(int i : stones){
            sum += i;
        }
        int target = sum / 2;
        // 遍历
        for(int i = 0; i < stones.length; i++){
            for(int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }

}
