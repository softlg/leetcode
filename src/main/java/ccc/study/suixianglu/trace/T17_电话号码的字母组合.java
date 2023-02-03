package ccc.study.suixianglu.trace;

import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/3 19:23
 */
public class T17_电话号码的字母组合 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
            https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    List<String> rs  = new LinkedList<>();
    // 初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return rs;
        }
        backTracking(digits,0);
        return rs;
    }

    StringBuilder sb = new StringBuilder();

    public void backTracking(String digits, int index){
        // 遍历全部一次记录一次得到的字符串
        if(index == digits.length()){
            rs.add(sb.toString());
            return;
        }
        //
        String string = str[digits.charAt(index) - '0'];

        for(int i = 0; i < string.length(); i++){
            sb.append(string.charAt(i));
            backTracking(digits, index + 1);
            // 剔除末尾的继续尝试
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
