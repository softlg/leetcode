package com.study.leetcode.September;

/**
 * @author： LiaoGuang
 * @date： 2022/9/27 10:59
 * Description：
 */
public class T剑指Offer58II_左旋转字符串 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
        请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
        该函数将返回左旋转两位得到的结果"cdefgab"。

    --------------------------------------------------------------------------------
    解题思路：
        通过局部反转+整体反转 达到左旋转的目的。
        具体步骤为：
            1.反转区间为前n的子串
            2.反转区间为n到末尾的子串
            3.反转整个字符串
        最后就可以得到左旋n的目的，而不用定义新的字符串，完全在本串上操作。
    --------------------------------------------------------------------------------
    */

    public static String reverseLeftWords(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        return sb.reverse().toString();
    }
    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s, 2));
    }
}

/**
 * StringBuilder
 */
class solution{
    public String reverseLeftWords(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        return sb.reverse().toString();
    }
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}