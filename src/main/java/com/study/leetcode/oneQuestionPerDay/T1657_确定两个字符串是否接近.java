package com.study.leetcode.oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author c
 */
public class T1657_确定两个字符串是否接近 {
    /*
      难度：medium
      --------------------------------------------------------------------------------
      题目：
              如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：

            操作 1：交换任意两个 现有 字符。
            例如，abcde -> aecdb
            操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
            例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
            你可以根据需要对任意一个字符串多次使用这两种操作。

            给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
      --------------------------------------------------------------------------------
      解题思路：
            方法一：计数 + 排序

            根据题目描述，两个字符串接近，需要同时满足以下两个条件：

            字符串 word1 和 word2 包含的字母种类必须相同；
            将字符串 word1 和 word2 的所有字符出现次数排序，得到的两个数组必须相同。
            因此，我们可以先用数组或哈希表分别统计 word1 和 word2 中每种字母出现的次数，然后比较两者是否相同，不相同则提前返回 false。

            否则，我们将对应的次数排序，然后依次比较对应位置的两个次数是否相同，不同则返回 false

      --------------------------------------------------------------------------------
     */

    public boolean closeStrings(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < word1.length(); ++i) {
            ++cnt1[word1.charAt(i) - 'a'];
        }
        for (int i = 0; i < word2.length(); ++i) {
            ++cnt2[word2.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if ((cnt1[i] == 0) != (cnt2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        return Arrays.equals(cnt1, cnt2);
    }

}
