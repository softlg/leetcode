package com.study.leetcode.oneQuestionPerDay;

/**
 * @author c
 * @date 2022/11/11 20:11
 */
public class T1704_判断字符串的两半是否相似 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。

        两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。
        注意，s 可能同时含有大写和小写字母。

        如果 a 和 b 相似，返回 true ；否则，返回 false 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/determine-if-string-halves-are-alike
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public boolean halvesAreAlike(String s) {
        return getNum(s.substring(0,s.length()/2)) == getNum(s.substring(s.length()/2,s.length()));
    }

    public int getNum(String str){
        if(str.length() == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o'|| str.charAt(i) == 'u'|| str.charAt(i) == 'A'
                    || str.charAt(i) == 'E'|| str.charAt(i) == 'I'|| str.charAt(i) == 'O'|| str.charAt(i) == 'U'){
                count++;
            }
        }
        return count;
    }
}
