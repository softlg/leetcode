package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/3 19:20
 */
public class T216_组合总和III {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

        只使用数字1到9
        每个数字 最多使用一次 
        返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/combination-sum-iii
    --------------------------------------------------------------------------------
    解题思路：
           回溯
    --------------------------------------------------------------------------------
     */

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    public void backTracking(int targetSum, int k, int index, int sum){
        // 减枝
        if(sum > targetSum){
            return;
        }

        if(path.size() == k){
            if(sum == targetSum){
                result.add(new ArrayList<>(path));
                return;
            }
        }
        // 减枝
        for(int i = index; i <= 9 - (k - path.size()) + 1; i++){
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            // 回溯
            path.removeLast();
            sum -= i;
        }
    }
}
