package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/19 22:02
 */
public class T47_全排列II {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTracking(nums);
        return res;
    }

    public void backTracking(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }

        // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
        // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
        // 如果同⼀树层nums[i - 1]使⽤过则直接跳过

        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false){
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
