package com.study.leetcode.template;

/**
 * @author c
 * 2022/7/27
 */
public class 滑动窗口模板 {

    /**
     * 1 、最长模板
     */
    /* -----------------------------------

    初始化 left，right，result，bestResult
    while("右指针没有到结尾"){
        窗口扩大，加入right对应元素，更新当前result
        while("result不满足要求"){
            窗口缩小，移除left对应元素，left右移
        }
        更新最优结果bestResult
        right++;
    }
    返回bestResult

    ----------------------------------- */

    /**
     * 2 、最短模板
     */
    /* -----------------------------------

    初始化 left，right，result，bestResult
    while("右指针没有到结尾"){
        窗口扩大，加入right对应元素，更新当前result
        while("result满足要求"){
            更新最优结果bestResult
            窗口缩小，移除left对应元素，left右移
        }
        right++;
    }
    返回bestResult

    ----------------------------------- */

}
