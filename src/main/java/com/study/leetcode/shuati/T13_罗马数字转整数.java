package com.study.leetcode.shuati;

/**
 * @author c
 * @date 2023/2/2 18:46
 */
public class T13_罗马数字转整数 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
            https://leetcode.cn/problems/roman-to-integer/
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int romanToInt(String s) {
        int thisValue = getValue(s.charAt(s.length()-1));
        int preValue = 0;
        int result = thisValue;
        for(int i = s.length()-1 ; i>0 ; i--){
            thisValue = getValue(s.charAt(i));
            preValue = getValue(s.charAt(i-1));
            if(thisValue>preValue){
                result-=preValue;
            }else{
                result+=preValue;
            }
        }
        return result;
    }
    public int getValue(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:return 0;
        }
    }
}
