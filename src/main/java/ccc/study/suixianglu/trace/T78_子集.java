package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/18 19:57
 */
public class T78_子集 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums,0);
        return res;
    }

    public void backTracking(int[] nums, int startIndex){
        // 遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        res.add(new ArrayList(path));
        //
        for(int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
