package com.study.leetcode.july;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rock
 */
public class T205_同构字符串 {
    /*
    解题思路：
       我们可以利用一个 map 来处理映射。对于 s 到 t 的映射，我们同时遍历 s 和 t ，
       假设当前遇到的字母分别是 c1 和 c2 。

       1、如果 map[c1] 不存在，那么就将 c1 映射到 c2 ，即 map[c1] = c2。

       2、如果 map[c1] 存在，那么就判断 map[c1] 是否等于 c2，也就是验证之前的映射和当前的字母是否相同。


       对于这道题，我们只需要验证 s - > t 和 t -> s 两个方向即可。如果验证一个方向，是不可以的。

        举个例子，s = ab, t = cc，如果单看 s -> t ，那么 a -> c, b -> c 是没有问题的。

        必须再验证 t -> s，此时，c -> a, c -> b，一个字母对应了多个字母，所以不是同构的。

        代码的话，只需要调用两次上边的代码即可。

     */

    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private static boolean isIsomorphicHelper(String s, String t) {
        // 定义Map
        Map<Character,Character> map = new HashMap<>();
        // 遍历
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            char d = t.charAt(i);
            if (map.containsKey(c)){
                if (map.get(c) != d){
                    return false;
                }
            }else {
                map.put(c, d);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper", t = "title";
        isIsomorphic(s,t);
    }
}
