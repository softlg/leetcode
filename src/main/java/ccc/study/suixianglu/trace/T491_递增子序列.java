package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/19 18:12
 */
public class T491_递增子序列 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。

        数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/non-decreasing-subsequences
    --------------------------------------------------------------------------------
    解题思路：
            回溯
    --------------------------------------------------------------------------------
     */

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int startIndex){
        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
        }
        //
        int[] used = new int[201];
        for(int i = startIndex; i < nums.length; i++){
            if(!path.isEmpty() && nums[i] < path.get(path.size() - 1) ||
                    (used[nums[i] + 100] == 1)){
                continue;
            }
            //
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

}
