package ccc.study.suixianglu.greed;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author c
 * @date 2023/2/25 22:30
 */
public class T1005_K次取反后最大化的数组和 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：

        选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
        重复这个过程恰好 k 次。可以多次选择同一个下标 i 。

        以这种方式修改数组后，返回数组 可能的最大和 。

        链接：https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations
    --------------------------------------------------------------------------------
    解题思路：
        第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        第二步：从前向后遍历，遇到负数将其变为正数，同时K--
        第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
        第四步：求和
    --------------------------------------------------------------------------------
     */

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完
        if (k % 2 == 1){
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();
    }
}
