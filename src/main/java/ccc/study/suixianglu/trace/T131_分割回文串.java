package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/11 15:31
 */
public class T131_分割回文串 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

        回文串 是正着读和反着读都一样的字符串。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    List<List<String>> result = new LinkedList<>();
    Deque<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return result;
    }

    public void backTracking(String s, int startIndex){
        if(startIndex >= s.length()){
            result.add(new ArrayList(path));
            return;
        }
        //
        for(int i = startIndex; i < s.length(); i++){
            // 判断是否是回文字符串
            if(judge(s, startIndex, i)){
                // 如果是，加入path
                String str = s.substring(startIndex,i + 1);
                path.add(str);
            }else{
                continue;
            }
            // 回溯
            backTracking(s, i + 1);
            path.removeLast();
        }
    }

    public Boolean judge(String s, int startIndex, int end){
        for(int i = startIndex; startIndex < end; i++, end--){
            if(s.charAt(i) != s.charAt(end)){
                return false;
            }
        }
        return true;
    }
}
