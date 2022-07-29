package com.study.leetcode.oneQuestionPerDay;

import java.util.HashSet;

/**
 * @author c
 * 2022/7/29
 */
public class T593_有效的正方形 {
    /*
    --------------------------------------------------------------------------------
    题目：
        给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。

        点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。

        一个 有效的正方形 有四条等边和四个等角(90度角)。
    --------------------------------------------------------------------------------

    解题思路：
      该图形是正方形，那么点和点的距离只有两种结果，边长和对角线，且对角线是边长的根号2倍，我们用此条件作为判断。
    --------------------------------------------------------------------------------
     */

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<>();
        //存放点和点之间的距离
            set.add(distance(p1, p2));
            set.add(distance(p1, p3));
            set.add(distance(p1, p4));
            set.add(distance(p2, p3));
            set.add(distance(p2, p4));
            set.add(distance(p3, p4));
        //只有两种结果 并且距离不是0
            if (set.size() != 2 || set.contains(0)) {
            return false;
        }
        //是不是根号2倍 平方就是2倍
        Integer[] array = set.toArray(new Integer[2]);
            if (array[0] > array[1]) {
            return array[0] == 2 * array[1];
        } else {
            return array[1] == 2 * array[0];
        }
    }

    public int distance(int[] p1, int[] p2) {
        int edge1 = p1[0] - p2[0];
        int edge2 = p1[1] - p2[1];
        return edge1 * edge1 + edge2 * edge2;
    }

}
