package com.study.leetcode.October;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author： liaoguang
 * @date： 2022/10/19 9:19
 * Description：
 */
public class T150_逆波兰表达式求值 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        根据 逆波兰表示法，求表达式的值。

        有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

        注意两个整数之间的除法只保留整数部分。

        可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
    */

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for(String s : tokens){
            if("+".equals(s)){
                deque.push(deque.pop() + deque.pop());
            }else if("-".equals(s)){
                deque.push(-deque.pop() + deque.pop());
            }else if("*".equals(s)){
                deque.push(deque.pop() * deque.pop());
            }else if("/".equals(s)){
                int temp1 = deque.pop();
                int temp2 = deque.pop();
                deque.push(temp2 / temp1);
            }else{
                deque.push(Integer.valueOf(s));
            }
        }
        return deque.pop();
    }

}
