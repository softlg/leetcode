package com.study.leetcode.july;

public class T35 {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int r = 0, l = nums.length;
        while(r < l){
            int mid = r + ((r + l) >> 2);
            if(mid < target){
                r = mid + 1;
            }else if(mid > target){
                l = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }


}
