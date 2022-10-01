package com.study.leetcode.September;

/**
<<<<<<< HEAD
 * @author c
 * @date 2022/9/25 1:02
=======
 * @author： LiaoGuang
 * @date： 2022/9/26 10:18
 * Description：
>>>>>>> origin/master
 */
public class T541_反转字符串II {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

        如果剩余字符少于 k 个，则将剩余字符全部反转。
        如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
    --------------------------------------------------------------------------------
    解题思路：
        这道题目其实也是模拟，实现题目中规定的反转规则就可以了。

        一些同学可能为了处理逻辑：每隔2k个字符的前k的字符，写了一堆逻辑代码或者再搞一个计数器，来统计2k，再统计前k个字符。

        其实在遍历字符串的过程中，只要让 i += (2 * k)，i 每次移动 2 * k 就可以了，然后判断是否需要有反转的区间。

        因为要找的也就是每2 * k 区间的起点，这样写，程序会高效很多。
    --------------------------------------------------------------------------------
    */

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < s.length(); i += 2 * k){
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if(i + k < s.length()){
                reverse(chars,i,i + k - 1);
                continue;
            }
            // 剩余字符少于 k 个，则将剩余字符全部反转。
            reverse(chars,i,s.length() - 1);
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int end){
        for (; start < end; start++,end--) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s,2));
    }

}
