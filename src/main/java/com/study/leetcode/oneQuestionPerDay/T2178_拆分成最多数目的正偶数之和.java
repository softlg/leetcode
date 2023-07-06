package com.study.leetcode.oneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

public class T2178_拆分成最多数目的正偶数之和 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个整数 finalSum 。请你将它拆分成若干个 互不相同 的正偶数之和，且拆分出来的正偶数数目 最多 。

        比方说，给你 finalSum = 12 ，那么这些拆分是 符合要求 的（互不相同的正偶数且和为 finalSum）：(2 + 10) ，(2 + 4 + 6) 和 (4 + 8) 。
        它们中，(2 + 4 + 6) 包含最多数目的整数。注意 finalSum 不能拆分成 (2 + 2 + 4 + 4) ，因为拆分出来的整数必须互不相同。
        请你返回一个整数数组，表示将整数拆分成 最多 数目的正偶数数组。
        如果没有办法将 finalSum 进行拆分，请你返回一个 空 数组。你可以按 任意 顺序返回这些整数。
    --------------------------------------------------------------------------------
    解题思路：
        贪心

        如果 finalSum 是奇数，那么无法拆分成若干个互不相同的正偶数之和，直接返回空数组。

            否则，我们可以贪心地按照 2,4,6,⋯ 的顺序拆分 finalSum，直到 finalSum 无法再拆分出一个不同的正偶数为止，
            此时我们将剩余的 finalSum 加到最后一个正偶数上即可。

    --------------------------------------------------------------------------------
     */

    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 == 1) {
            return ans;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        ans.add(ans.remove(ans.size() - 1) + finalSum);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumEvenSplit(28l));
    }
}
