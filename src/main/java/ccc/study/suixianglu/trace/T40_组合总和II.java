package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/11 13:50
 */
public class T40_组合总和II {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

        candidates 中的每个数字在每个组合中只能使用 一次 。

        注意：解集不能包含重复的组合。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/combination-sum-ii
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */


    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backTracking(candidates,target,0);
        return result;
    }

    public void backTracking(int[] candidates, int target, int index){
        if (sum == target) {
            result.add(new ArrayList(path));
        }
        //
        for(int i = index; i < candidates.length; i++){
            if(sum + candidates[i] > target){
                break;
            }
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
