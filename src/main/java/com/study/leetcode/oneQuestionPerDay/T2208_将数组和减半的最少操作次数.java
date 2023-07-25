package com.study.leetcode.oneQuestionPerDay;

import java.util.Collections;
import java.util.PriorityQueue;

public class T2208_将数组和减半的最少操作次数 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。
        （注意，在后续操作中你可以对减半过的数继续执行操作）

        请你返回将 nums 数组和 至少 减少一半的 最少 操作数。
    --------------------------------------------------------------------------------

    解题思路：

    --------------------------------------------------------------------------------
     */

    public static int halveArray(int[] nums) {
        double s = 0;
        PriorityQueue<Double> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : nums) {
            q.offer(v * 1.0);
            s += v;
        }
        s /= 2.0;
        int ans = 0;
        while (s > 0) {
            double t = q.poll();
            s -= t / 2.0;
            q.offer(t / 2.0);
            ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,19,8,1};
        int i = halveArray(nums);
        System.out.println(i);
    }
}
