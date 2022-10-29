package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

/**
 * @author c
 * @date 2022/10/29 21:35
 */
public class T110_平衡二叉树 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个二叉树，判断它是否是高度平衡的二叉树。

        本题中，一棵高度平衡二叉树定义为：

        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
    --------------------------------------------------------------------------------
    解题思路：
        后续遍历 递归 迭代
    --------------------------------------------------------------------------------
     */

    public boolean isBalanced(TreeNode root) {
        return getHight(root) != -1;
    }

    public int getHight(TreeNode root){
        if (root == null) {
            return 0;
        }
        // 后续遍历
        int leftHight = getHight(root.left);
        if(leftHight == -1){
            return -1;
        }
        int rightHigth = getHight(root.right);
        if(rightHigth == -1){
            return -1;
        }
        //
        if(Math.abs(leftHight - rightHigth) > 1){
            return -1;
        }
        return Math.max(leftHight,rightHigth) + 1;
    }
}
