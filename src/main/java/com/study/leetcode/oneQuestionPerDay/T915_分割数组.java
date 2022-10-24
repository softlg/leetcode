package com.study.leetcode.oneQuestionPerDay;

/**
 * @author： liaoguang
 * @date： 2022/10/24 9:28
 * Description：
 */
public class T915_分割数组 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个数组nums，将其划分为两个连续子数组left和right，使得：

        left中的每个元素都小于或等于right中的每个元素。
        left 和right都是非空的。
        left 的长度要尽可能小。
        在完成这样的分组后返回left的长度。

        用例可以保证存在这样的划分方法。

        输入：nums = [5,0,3,8,6]
        输出：3
        解释：left = [5,0,3]，right = [8,6]
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
    */

    public int partitionDisjoint2(int[] nums) {
        int n = nums.length;
        int[] mi = new int[n + 1];
        mi[n] = nums[n - 1];
        for (int i = n - 1; i >= 0; --i) {
            mi[i] = Math.min(nums[i], mi[i + 1]);
        }
        int mx = 0;
        for (int i = 1; i <= n; ++i) {
            int v = nums[i - 1];
            mx = Math.max(mx, v);
            if (mx <= mi[i]) {
                return i;
            }
        }
        return 0;
    }


    public int partitionDisjoint(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            min[0] = nums[0];
            int maxNum = Integer.MIN_VALUE;
            for(int j = 1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    for (int k = 0; k < nums.length - j; k++) {
                        nums[j] = nums[k];
                    }
                } else if (nums[j] < nums[i]) {
                    maxNum = nums[i];
                    nums[i] = nums[j];
                }
            }

        }
        return 0;
    }
}
