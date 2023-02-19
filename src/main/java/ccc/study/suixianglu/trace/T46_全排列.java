package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/19 21:45
 */
public class T46_全排列 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    --------------------------------------------------------------------------------
    解题思路：
        每层都是从0开始搜索而不是startIndex
        需要used数组记录path里都放了哪些元素了
    --------------------------------------------------------------------------------
     */

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backTracking(nums);
        return res;
    }

    public void backTracking(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
