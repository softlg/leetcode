package com.study.leetcode.September;

/**
 * @author： LiaoGuang
 * @date： 2022/9/26 11:10
 * Description：
 */
public class T剑指Offer05_替换空格 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
    */

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        // 选用 StringBuilder 单线程使用，比较快，选不选都行
        StringBuilder sb = new StringBuilder();
        // 使用 sb 逐个复制 str ，碰到空格则替换，否则直接复制
        for (int i = 0; i < s.length(); i++) {
            // str.charAt(i) 为 char 类型，为了比较需要将其转为和 " " 相同的字符串类型
            // if (" ".equals(String.valueOf(str.charAt(i)))){
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
