package ccc.study.suixianglu.greed;

/**
 * @author c
 * @date 2023/3/26 20:38
 */
public class T738_单调递增的数字 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。

        给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。

        链接：https://leetcode.cn/problems/monotone-increasing-digits
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int monotoneIncreasingDigits(int N) {
        String[] strings = (N + "").split("");
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("",strings));
    }

}
