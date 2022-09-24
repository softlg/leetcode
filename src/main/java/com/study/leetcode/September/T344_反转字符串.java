package com.study.leetcode.September;

import java.util.Arrays;

/**
 * @author c
 * @date 2022/9/25 0:57
 */
public class T344_反转字符串 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

        不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

    --------------------------------------------------------------------------------
    解题思路：
        双指针
    --------------------------------------------------------------------------------
     */

    public void reverseString(char[] s) {
        // 定义双指针
        int left = 0, right = s.length - 1;
        while(right > left){
            Character temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }
}
