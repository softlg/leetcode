package lc.rating.score_1200_1400;

import lombok.var;

import java.util.HashSet;

public class T2367_算术三元组的数目 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：

        i < j < k ，
        nums[j] - nums[i] == diff 且
        nums[k] - nums[j] == diff
        返回不同 算术三元组 的数目。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        var set = new HashSet<Integer>();
        for(int x : nums) set.add(x);
        for(int x : nums){
            if(set.contains(x -diff) && set.contains(x + diff)){
                ans++;
            }
        }
        return ans;
    }

}
