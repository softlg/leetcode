package ccc.study.suixianglu.greed;
/**
 * @author c
 * @date 2023/2/23 0:22
 */
public class T45_跳跃游戏II {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

        每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

        0 <= j <= nums[i] 
        i + j < n
        返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

        链接：https://leetcode.cn/problems/jump-game-ii
    --------------------------------------------------------------------------------
    解题思路：
        局部贪心
    --------------------------------------------------------------------------------
     */

    public int jump(int[] nums) {
        // 当前覆盖的最远距离下标
        int curDistance = 0;
        // 记录走的最大步数
        int ans = 0;
        // 下一步覆盖的最远距离下标
        int nextDistance = 0;
        // 注意这里是小于nums.size() - 1，这是关键所在
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新下一步覆盖的最远距离下标
            nextDistance = Math.max(nums[i] + i, nextDistance);
            // 遇到当前覆盖的最远距离下标
            if (i == curDistance) {
                // 更新当前覆盖的最远距离下标
                curDistance = nextDistance;
                ans++;
            }
        }
        return ans;
    }

}
