package com.study.leetcode.shuati;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author c
 * @date 2023/2/2 22:20
 */
public class T6_N字形变换 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        https://leetcode.cn/problems/zigzag-conversion/
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    /**
     * 解法一
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) {
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    /**
     * 解法2
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        //
        String[] stringArray = new String[numRows];
        Arrays.fill(stringArray,"");
        char[] ch = s.toCharArray();
        // 周期为 2*n - 2
        int period = numRows * 2 - 2;
        //
        for (int i = 0; i < ch.length; i++) {
            int mod = i % period;
            if(mod < numRows){
                stringArray[mod] += ch[i];
            }else{
                stringArray[period - mod] += ch[i];
            }
        }
        // 转字符串
        StringBuilder rs = new StringBuilder();
        for(String str : stringArray){
            rs.append(str);
        }
        return rs.toString();
    }
}
