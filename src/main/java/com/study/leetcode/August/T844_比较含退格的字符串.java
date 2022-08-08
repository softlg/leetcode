package com.study.leetcode.August;

import java.util.Stack;

/**
 * @author c
 * @date 2022/8/8 9:32
 */
public class T844_比较含退格的字符串 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。

        注意：如果对空文本输入退格字符，文本继续为空。

    --------------------------------------------------------------------------------
    解题思路：
            之前用双指针解本题感觉逻辑不是很好写, 其实本题用栈来解决会非常轻松
    --------------------------------------------------------------------------------
     */


    public static boolean backspaceCompare(String s, String t) {
        return isSameStack(deal(s),deal(t));
    }

    public static Stack deal(String str){
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != '#' && str.charAt(i) != ' '){
                stack.push(str.charAt(i));
            }else if (str.charAt(i) != ' '){
                // 注意第一个为#，pop报错EmptyStackException
                if(stack.size() > 0){
                    stack.pop();
                }
            }
        }
        return stack;
    }

    /**
     * 判断两个栈内元素是否相等
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isSameStack(Stack s1,Stack s2){
        if(s1.size() != s2.size()){
            return false;
        }
        while(s1.empty() == false) {
            if (s1.peek() == s2.peek()) {
                s1.pop();
                s2.pop();
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        boolean b = backspaceCompare(s, t);
        System.out.println("--------"+b);
    }
}
