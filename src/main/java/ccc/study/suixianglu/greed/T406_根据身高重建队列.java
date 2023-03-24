package ccc.study.suixianglu.greed;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author c
 * @date 2023/3/23 21:51
 */
public class T406_根据身高重建队列 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
        每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

        请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
        其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

        链接：https://leetcode.cn/problems/queue-reconstruction-by-height
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */


    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);
        }

        return que.toArray(new int[people.length][]);
    }
}
