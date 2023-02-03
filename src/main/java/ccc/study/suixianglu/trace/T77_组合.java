package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/3 16:51
 * 回溯
 */
public class T77_组合 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

        你可以按 任何顺序 返回答案。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    public void backtracking(int n, int k, int index){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        //
        for(int i = index; i <= n; i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }

}
