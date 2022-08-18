package com.study.leetcode.August;
/**
 * @author c
 * @date 2022/8/18 13:32
 */
public class T日志易_查找字符串位置 {
    /**
     * 解题思路：
     *      枚举原串 ss 中的每个字符作为「发起点」，每次从原串的「发起点」和匹配串的「首位」开始尝试匹配：
     *          匹配成功：返回本次匹配的原串「发起点」。
     *          匹配失败：枚举原串的下一个「发起点」，重新尝试匹配。
     */
    public static void main(String[] args) {
        System.out.println(indexOf("abcabdef","abd"));
    }

    public static int indexOf(String source, String target){
        int n = source.length(), m = target.length();
        // 转换为字符数组
        char[] s = source.toCharArray(), t = target.toCharArray();
        // 枚举原串的 发起点
        for (int i = 0; i <= n - m; i++) {
            // 从原串的 发起点 和匹配串的 首位 开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == t[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的 发起点 下标
            if (b == m) {
                return i;
            }
        }
        return -1;
    }

}
