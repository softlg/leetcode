package com.study.leetcode.shuati;

/**
 * @author c
 * @date 2023/2/3 16:33
 */
public class T11_盛最多水的容器 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

        返回容器可以储存的最大水量。

        说明：你不能倾斜容器。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/container-with-most-water
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1,rs = 0;
        while(i < j){
            rs = height[i] < height[j] ? Math.max(rs,((j - i) * height[i++])) : Math.max(rs,((j - i) * height[j--]));
        }
        return rs;
    }
}
