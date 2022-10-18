package com.study.leetcode.October;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author： liaoguang
 * @date： 2022/10/18 18:00
 * Description：
 */
public class T20_有效的括号 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
    */

    public boolean isValid(String s) {
        Deque<Character> de = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                de.push(')');
            }else if(s.charAt(i) == '['){
                de.push(']');
            }else if(s.charAt(i) == '{'){
                de.push('}');
            }else if(de.isEmpty() || de.peek() != s.charAt(i)){
                return false;
            }else {
                // 如果是右括号判断是否和栈顶元素匹配
                de.pop();
            }
        }
        return de.isEmpty();
    }
}
