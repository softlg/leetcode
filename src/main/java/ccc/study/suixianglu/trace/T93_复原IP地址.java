package ccc.study.suixianglu.trace;

import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/11 16:33
 */
public class T93_复原IP地址 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：

        有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

        例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
        但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。

        给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
        这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/restore-ip-addresses
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    List<String> result = new LinkedList<>();
    int pointNum = 0;

    public List<String> restoreIpAddresses(String s) {
        // 剪枝
        if(s.length() > 12){
            return result;
        }
        backTracking(s, 0);
        return result;
    }

    public void backTracking(String s, int startIndex){
        // 逗点数量为3时，分隔结束
        if(pointNum == 3){
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if(isValid(s, startIndex, s.length() - 1)){
                result.add(s);
            }
            return;
        }
        //
        for(int i = startIndex; i < s.length(); i++){
            // 判断合法，合法加上一点
            if(isValid(s, startIndex, i)){
                // 在str的后⾯插⼊⼀个逗点
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                backTracking(s, i + 2);
                pointNum--;
                // 回溯删掉逗点
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }else{
                break;
            }
        }
    }

    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            // 如果⼤于255了不合法
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
