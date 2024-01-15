package lc.rating.score_1200_1400;


import java.util.ArrayDeque;
import java.util.Deque;

public class T2124_检查是否所有A都在B之前 {
     /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个 仅 由字符 'a' 和 'b' 组成的字符串  s 。如果字符串中 每个 'a' 都出现在 每个 'b' 之前，返回 true ；否则，返回 false 。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public boolean checkString(String s) {
        Deque<Character> dp = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(dp.peek() == null){
                dp.push(c);
                continue;
            }
            // 前面是 a
            if(dp.peek() == 'a'){
                if (c == 'a'){
                    continue;
                }else{
                    dp.push(c);
                }
            }
            // 前面是 b
            if(dp.peek() == 'b' && (c == 'a')){
                return false;
            }
        }
        return true;
    }

}
