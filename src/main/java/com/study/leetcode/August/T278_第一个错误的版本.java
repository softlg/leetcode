package com.study.leetcode.August;
/**
 * @author c
 * 2022/8/1
 */
public class T278_第一个错误的版本 {

    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于
        之前的版本开发的，所以错误的版本之后的所有版本都是错的。

        假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

        你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找
        第一个错误的版本。你应该尽量减少对调用 API 的次数。

    --------------------------------------------------------------------------------
    解题思路：
        二分查找的思路，如果中间版本为正确版本，那么第一个错误版本肯定在它的右侧，所以将左边界设为mid+1；
        如果中间版本为错误版本，那么第一个错误版本要么等于它，要么在它左侧，所以右边界设为mid。当left等于right的时候，
        left已经指向了第一个错误版本了。

    --------------------------------------------------------------------------------
     */
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i <= j) {
            // 向下取整除法计算中点 m
            int m = i + (j - i) / 2;
            // 若 m 是错误版本，则最后一个正确版本一定在闭区间 [i, m - 1]
            if (isBadVersion(m)){
                j = m - 1;
            }
            // 若 m 是正确版本，则首个错误版本一定在闭区间 [m + 1, j]
            else{
                i = m + 1;
            }
        }
        // i 指向首个错误版本，j 指向最后一个正确版本
        return i;

    }

    private Boolean isBadVersion(int m){
        // 随便写的，让代码不报错
        return Boolean.TRUE;
    }
}
