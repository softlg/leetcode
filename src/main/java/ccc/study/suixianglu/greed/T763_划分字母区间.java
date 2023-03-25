package ccc.study.suixianglu.greed;

import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/3/25 21:12
 */
public class T763_划分字母区间 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。

        注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。

        返回一个表示每个字符串片段的长度的列表。

        链接：https://leetcode.cn/problems/partition-labels
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx,edge[chars[i] - 'a']);
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels(
                "ababcbacadefegdehijhklij"));
    }

}
