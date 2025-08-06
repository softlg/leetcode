package lc.rating.score_1200_1400;

import java.util.Arrays;

public class T2148_元素计数 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static int countElements(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        Arrays.sort(nums);
        int restemp = nums.length - 2;
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] == nums[0] || nums[i] == nums[nums.length - 1]){
                restemp--;
            }
        }
        return restemp;
    }

    public static void main(String[] args) {
        int[] nums = {11,7,2,15};
        System.out.println(countElements(nums));
    }

}
