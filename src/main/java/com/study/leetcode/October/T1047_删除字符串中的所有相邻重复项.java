package com.study.leetcode.October;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author： liaoguang
 * @date： 2022/10/18 18:02
 * Description：
 */
public class T1047_删除字符串中的所有相邻重复项 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

        在 S 上反复执行重复项删除操作，直到无法继续删除。

        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
    */

    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char ch;
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            if(deque.isEmpty() || deque.peek() != ch){
                deque.push(ch);
            }else{
                deque.pop();
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }

}
