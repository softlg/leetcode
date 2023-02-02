package com.study.leetcode.shuati;

/**
 * @author c
 * @date 2023/2/2 14:43
 */
public class T12_整数转罗马数字 {

    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
            https://leetcode.cn/problems/integer-to-roman/
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public String intToRoman(int num) {
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rm = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        //
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; ++i){
            while(num >= nums[i]){
                // 存在， 减去当前值
                num -= nums[i];
                sb.append(rm[i]);
            }
        }
        return sb.toString();
    }
}
