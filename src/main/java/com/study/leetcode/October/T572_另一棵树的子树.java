package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

/**
 * @author c
 * @date 2022/10/30 20:59
 */
public class T572_另一棵树的子树 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。

        二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/subtree-of-another-tree
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // subRoot 为 null 一定都是 true
        if (subRoot == null) return true;
        // 这里 subRoot 一定不为 null, 只要 root 为 null，肯定是 false
        if (root == null) return false;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) || isSameTree(root,subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
