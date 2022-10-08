package com.study.leetcode.October;

/**
 * @author c
 * @date 2022/10/3 22:09
 */
public class T459_重复的子字符串 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static boolean repeatedSubstringPattern(String s) {
        if(s.equals(" ")){
            return false;
        }
        int[] next = new int[s.length()];
        getNext(next,s);
        System.out.println(next.toString());
        // 最后判断是否是重复的子字符串，这里 next[s.length()] 即代表next数组末尾的值
        if(next[s.length() - 1] > 0 && s.length() % (s.length() - next[s.length() - 1]) == 0){
            return true;
        }
        return false;
    }

    public static void getNext(int[] next, String str){
        // 1、初始化
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < str.length(); i++){
            // 2、前后缀不相等的情况
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                // 回退
                j = next[j - 1];
            }
            // 3、前后缀相等的情况
            if(str.charAt(i) == str.charAt(j)){
                //
                j++;
            }
            // 更新next数组
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abacb"));
    }
}
