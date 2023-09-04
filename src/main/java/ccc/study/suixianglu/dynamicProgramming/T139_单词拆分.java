package ccc.study.suixianglu.dynamicProgramming;

import java.util.List;

/**
 * @author c
 * @date 2023-9-4 16:18:40
 */
public class T139_单词拆分 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。

        注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    --------------------------------------------------------------------------------
    解题思路：
           dp
    --------------------------------------------------------------------------------
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        // 定义dp数组
        boolean[] dp = new boolean[s.length() + 1];
        // 初始化
        dp[0] = true;
        // 求排列，先遍历背包，再遍历物品
        for(int i = 1; i <= s.length(); i++){
            for(String word : wordDict){
                int len = word.length();
                if(i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
