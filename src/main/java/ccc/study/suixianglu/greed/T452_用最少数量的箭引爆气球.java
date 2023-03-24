package ccc.study.suixianglu.greed;

import java.util.Arrays;

/**
 * @author c
 * @date 2023/3/24 22:18
 */
public class T452_用最少数量的箭引爆气球 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
        其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。

        一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
        若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。
        可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。

        给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。

        链接：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons
    --------------------------------------------------------------------------------
    解题思路：
           局部最优：当气球出现重叠，一起射，所用弓箭最少。全局最优：把所有气球射爆所用弓箭最少。
    --------------------------------------------------------------------------------
     */

    public static int findMinArrowShots(int[][] points) {
        // 根据气球直径的开始坐标从小到大排序
        // 使用Integer内置比较方法，不会溢出
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        // points 不为空至少需要一支箭
        int count = 1;
        //
        for(int i = 1; i < points.length; i++){
            // 气球i和气球i-1不挨着，注意这里不是>=
            if (points[i][0] > points[i - 1][1]) {
                // 需要一支箭
                count++;
            } else {  // 气球i和气球i-1挨着
                // 更新重叠气球最小右边界
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {10,16},{2,8},{1,6},{7,12}
        };
        System.out.println(findMinArrowShots(points));
    }

}
