package com.study.leetcode.july;

/**
 * @author c
 */
public class T329_判断子序列 {

    /*
    解题思路：
       设置双指针 i , j 分别指向字符串 s , t 的首个字符，遍历字符串 t ：

        当 s[i] == t[j] 时，代表匹配成功，此时同时 i++ , j++ ；
        进而，若 i 已走过 s 尾部，代表 s 是 t 的子序列，此时应提前返回 true ；
        当 s[i] != t[j] 时，代表匹配失败，此时仅 j++ ；
        若遍历完字符串 t 后，字符串 s 仍未遍历完，代表 s 不是 t 的子序列，此时返回 false 。

     */

    public static boolean isSubsequence(String s, String t) {
        //
        for(int i = 0, j = 0; j < t.length();j++){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                if(i == s.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "pe", t = "paper";
        isSubsequence(s,t);
    }


}
