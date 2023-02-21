package ccc.study.suixianglu.greed;

import java.util.Arrays;

/**
 * @author c
 * @date 2023/2/21 19:44
 */
public class T455_分发饼干 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

        对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
        都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
        你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

        链接：https://leetcode.cn/problems/assign-cookies
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    /**
     * 解法一
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        // 排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 统计
        int count = 0;
        int startIndex = 0;
        for(int i = 0; i < s.length; i++){
            for(int j = startIndex; j < g.length; j++){
                if(s[i] >= g[j]){
                    count++;
                    startIndex++;
                    break;
                }
            }
        }
        return count;
    }
}
