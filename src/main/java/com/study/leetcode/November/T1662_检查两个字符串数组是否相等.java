package com.study.leetcode.November;

/**
 * @author c
 * @date 2022/11/1 22:55
 */
public class T1662_检查两个字符串数组是否相等 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。

        数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。

    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return appendStr(word1).equals(appendStr(word2));
    }

    public static String appendStr(String[] word){
        if(word == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length; i++){
            sb.append(word[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] word1 = {"a", "bc"};
        String[] word2 = {"ab", "c"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }
}
