package com.study.leetcode.oneQuestionPerDay;

import lombok.var;

/**
 * @author c
 * @date 2023/3/15 22:09
 */
public class T1615_最大网络秩 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        https://leetcode.cn/problems/maximal-network-rank/
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] g = new int[n][n];
        int[] cnt = new int[n];
        for (var r : roads) {
            int a = r[0], b = r[1];
            g[a][b] = 1;
            g[b][a] = 1;
            ++cnt[a];
            ++cnt[b];
        }
        int ans = 0;
        for (int a = 0; a < n; ++a) {
            for (int b = a + 1; b < n; ++b) {
                ans = Math.max(ans, cnt[a] + cnt[b] - g[a][b]);
            }
        }
        return ans;
    }

}
