package com.study.leetcode.September;

import java.util.HashMap;
import java.util.Map;

/**
 * @author c
 * @date 2022/9/23 21:39
 */
public class T383_赎金信 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

        如果可以，返回 true ；否则返回 false 。

        magazine 中的每个字符只能在 ransomNote 中使用一次。
    --------------------------------------------------------------------------------
    解题思路：
        因为题目所只有小写字母，那可以采用空间换取时间的哈希策略， 用一个长度为26的数组还记录magazine里字母出现的次数。

        然后再用ransomNote去验证这个数组是否包含了ransomNote所需要的所有字母。

        依然是数组在哈希法中的应用。

        一些同学可能想，用数组干啥，都用map完事了，其实在本题的情况下，使用map的空间消耗要比数组大一些的，因为map要维护红黑树或
        者哈希表，而且还要做哈希函数，是费时的！数据量大的话就能体现出来差别了。 所以数组更加简单直接有效！

    --------------------------------------------------------------------------------
     */

    /**
     * 解法一
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        // 定义map存储ransomNote中的字符以及出现次数
        Map<Character,Integer> map = new HashMap<>(ransomNote.length());
        for(int i = 0; i < ransomNote.length(); i++){
            if(map.containsKey(ransomNote.charAt(i))){
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i)) + 1);
            }else{
                map.put(ransomNote.charAt(i),1);
            }
        }

        // 判断magazine中字符是否包含ransomNote所有字符（单字符只看使用一次）
        for(int i = 0; i < magazine.length(); i++){
            if(map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),map.get(magazine.charAt(i)) - 1);
                if(map.get(magazine.charAt(i)) == 0){
                    map.remove(magazine.charAt(i));
                }
            }
        }
        // 判断map是否存在值
        return map.size() > 0 ? false : true;
    }

    /**
     * 解法二
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "aa",b = "aab";
        System.out.println(canConstruct(a, b));
    }

}
