package ccc.study.suixianglu.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author c
 * @date 2023/3/26 20:10
 */
public class T56_合并区间 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
        请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

        链接：https://leetcode.cn/problems/merge-intervals
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        // 左边界
        int start = intervals[0][0];
        // 右边界
        int maxRight = intervals[0][1];
        // 遍历
        for(int i = 1; i < intervals.length; i++){
            // 第二个区间在前面区间里面
            if(maxRight >= intervals[i][0]){
                maxRight =  Math.max(maxRight, intervals[i][1]);
            }else{
                res.add(new int[]{start,maxRight});
                start = intervals[i][0];
                maxRight = intervals[i][1];
            }
        }
        res.add(new int[]{start, maxRight});
        return res.toArray(new int[res.size()][]);
    }

}
