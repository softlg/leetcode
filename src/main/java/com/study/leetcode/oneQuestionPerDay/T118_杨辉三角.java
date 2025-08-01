package com.study.leetcode.oneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguang
 * date: 2025-08-01 15:27:21
 * description: <a href="https://leetcode.cn/problems/pascals-triangle/description/?envType=daily-question&envId=2025-08-01">...</a>
 */
public class T118_杨辉三角 {


    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

        在「杨辉三角」中，每个数是它左上方和右上方的数的和。

        示例 1:

        输入: numRows = 5
        输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        示例 2:

        输入: numRows = 1
        输出: [[1]]
    --------------------------------------------------------------------------------

    解题思路：
    --------------------------------------------------------------------------------
     */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        // [1]
        // [1,1]
        // [1,2,1]
        // [1,3,3,1]
        res.add(List.of(1));
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                // 左上方的数 + 正上方的数
                row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        generate(6).forEach(System.out::println);
    }


}
