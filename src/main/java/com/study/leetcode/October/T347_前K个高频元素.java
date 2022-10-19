package com.study.leetcode.October;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author： liaoguang
 * @date： 2022/10/19 15:40
 * Description：
 */
public class T347_前K个高频元素 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
    */

    /**
     *  解法1：基于大顶堆实现
     * Comparator接口说明:
     * 返回负数，形参中第一个参数排在前面；返回正数，形参中第二个参数排在前面
     * 对于队列：排在前面意味着往队头靠
     * 对于堆（使用PriorityQueue实现）：从队头到队尾按从小到大排就是最小堆（小顶堆），
     *                              从队头到队尾按从大到小排就是最大堆（大顶堆）--->队头元素相当于堆的根节点
     * */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for(Integer num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        // 出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((par1,par2) -> par2[1] - par1[1]);
        // 大顶堆需要对所有元素进行排序
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        // 依次从队头弹出k个,就是出现频率前k高的元素
        int[] ans = new int[k];
        for(int i=0; i < k; i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

}
