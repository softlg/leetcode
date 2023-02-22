package ccc.study.suixianglu.greed;

/**
 * @author c
 * @date 2023/2/23 0:17
 */
public class T55_跳跃游戏 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

        数组中的每个元素代表你在该位置可以跳跃的最大长度。

        判断你是否能够到达最后一个下标。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int cover = 0;
        for(int i = 0; i <= cover; i++){
            cover = Math.max(cover,nums[i] + i);
            if(cover >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
