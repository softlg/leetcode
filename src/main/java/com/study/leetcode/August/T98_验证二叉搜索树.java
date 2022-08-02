package com.study.leetcode.August;

import javax.swing.tree.TreeNode;

/**
 * @author c
 * 2022/8/2
 */
public class T98_验证二叉搜索树 {

    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

        有效 二叉搜索树定义如下：

        节点的左子树只包含 小于 当前节点的数。
        节点的右子树只包含 大于 当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。

    --------------------------------------------------------------------------------
    解题思路：


    --------------------------------------------------------------------------------
     */

    // 用于判断当前节点的左节点
//    TreeNode pre=null;
//    public boolean isValidBST(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        if(!isValidBST(root.left)){
//            return false;
//        }
//        //这里用于判断是不是找到最左边的节点了，如果是就不用比较
//        if(pre==null) {
//            pre=root;
//        }
//        //如果不是就比较这个节点和其左节点
//        else if(root.val<=pre.val){
//            return false;
//        }
//        pre=root;
//        return isValidBST(root.right);
//    }
}
