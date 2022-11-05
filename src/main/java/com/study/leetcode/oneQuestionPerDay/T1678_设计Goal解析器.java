package com.study.leetcode.oneQuestionPerDay;

/**
 * @author c
 * @date 2022/11/6 0:10
 */
public class T1678_设计Goal解析器 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
        Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序
        将经解释得到的字符串连接成一个字符串。
        
        给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/goal-parser-interpretation
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < command.length(); i++){
            // TODO 字符串比较用 == ''  不可以用双引号和 equals
            if('G' ==command.charAt(i)){
                sb.append("G");
            }else if('(' == command.charAt(i)){
                if(')' == command.charAt(i + 1)){
                    sb.append("o");
                    i++;
                }else{
                    sb.append("al");
                    i += 3;
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "G()(al)";
        System.out.println(interpret(s));
    }
}
