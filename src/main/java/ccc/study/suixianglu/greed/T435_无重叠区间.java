package ccc.study.suixianglu.greed;

import java.util.Arrays;

/**
 * @author c
 * @date 2023/3/25 21:07
 */
public class T435_无重叠区间 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。

        链接：https://leetcode.cn/problems/non-overlapping-intervals
    --------------------------------------------------------------------------------
    解题思路：
        贪心
    --------------------------------------------------------------------------------
     */

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //
        int count = 0;
        int pre = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(pre > intervals[i][0]){
                count++;
                pre = Math.min(pre, intervals[i][1]);
            }else{
                pre = intervals[i][1];
            }
        }
        return count;
    }
}
