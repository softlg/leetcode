package com.study.leetcode.November;

import com.study.leetcode.util.TreeNode;

/**
 * @author c
 * @date 2022/11/5 23:41
 */
public class T112_路径总和 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

        叶子节点 是指没有子节点的节点。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/path-sum
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        targetSum -= root.val;
        // 叶子结点
        if(root.left == null && root.right ==null){
            return targetSum == 0;
        }
        // 左
        if(root.left != null){
            if(hasPathSum(root.left,targetSum)){
                return true;
            }
        }
        // 右
        if(root.right != null){
            if(hasPathSum(root.right,targetSum)){
                return true;
            }
        }
        return false;
    }
}
