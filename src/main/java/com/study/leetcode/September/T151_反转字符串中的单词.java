package com.study.leetcode.September;

/**
 * @author： c
 * @date： 2022/9/27 10:10
 * Description：
 */
public class T151_反转字符串中的单词 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你一个字符串 s ，请你反转字符串中 单词 的顺序。

        单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

        返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

        注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间
        应当仅用单个空格分隔，且不包含任何额外的空格。

    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
    */

    /**
     * 不使用Java内置方法实现
     * <p>
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    public String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' '){
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

//    public static String reverseWords(String s) {
//        // 1.去除首尾以及中间多余空格
//        String s1 = removeSpace(s);
//        // 2.反转整个字符串
//        String s2 = reverseString(s1,0,s1.length() - 1);
//        // 3.反转单个单词
//        String s3 = reverseEachWord(s2);
//        return s3;
//    }

//    public static String removeSpace(String s){
//        char[] chars = s.toCharArray();
//        // 定义快慢指针
//        int fast = 0, slow = 0;
//        for(int i = 0; i < chars.length; i++){
//            if(slow != 0){
//                chars[slow++] = ' ';
//            }
//            if(fast < chars.length && chars[fast] != ' '){
//                chars[slow] = chars[fast];
//                fast++;
//                slow++;
//            }
//        }
//        // 存在问题
//        return new String(chars);
//    }
//
//    public static String reverseString(String s,int start, int end){
//        char[] chars = s.toCharArray();
//        while(start < end){
//            chars[start] ^= chars[end];
//            chars[end] ^= chars[start];
//            chars[start] ^= chars[end];
//            end--;
//            start++;
//        }
//        return new String(chars);
//    }
//
//    public static String reverseEachWord(String s){
//        int start = 0, end = 1, n = s.length();
//        while (start < n){
//            while (end < n && s.charAt(end) != ' '){
//                end++;
//            }
//            reverseString(s,start,end - 1);
//            start = end + 1;
//            end = start + 1;
//        }
//        return s;
//    }
//
//    public static void main(String[] args) {
//        String s = "the sky is blue";
//        System.out.println(reverseWords(s));
//    }
}
