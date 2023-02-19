package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/19 17:52
 */
public class T90_子集II {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

        解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/subsets-ii
    --------------------------------------------------------------------------------
    解题思路：
            回溯
    --------------------------------------------------------------------------------
     */

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 排序
        Arrays.sort(nums);
        backTracking(nums, 0);
        return result;
    }

    public void backTracking(int[] nums, int startIndex){
        result.add(new ArrayList(path));
        //
        for(int i = startIndex; i < nums.length; i++){
            // 去重
            if(i > startIndex && nums[i - 1] == nums[i]){
                continue;
            }
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
