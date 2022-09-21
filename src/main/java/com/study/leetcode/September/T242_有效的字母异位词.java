package com.study.leetcode.September;
/**
 * @author：c
 * Date：2022/9/21
 */
public class T242_有效的字母异位词 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

        注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

    --------------------------------------------------------------------------------
    解题思路：
        统计两个字符中中每个字符出现的次数 将一个字符串中的字符出现的次数存入hash数组中，
        然后用hash数组中的字符出现的次数减去另外一个字符串中字符出现的次数
    --------------------------------------------------------------------------------
     */

    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        //
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a']++;
        }
        for(int j = 0; j < t.length(); j++){
            hash[t.charAt(j) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(hash[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "sadasdasdsa";
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[i] = s.charAt(i) - 'a';
            System.out.println(hash[i]);
        }

        int[] hash2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[i] = (s.charAt(i) - 'a');
            System.out.print(hash2);
        }
        System.out.println(hash.equals(hash2));
    }
}
