package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author c
 * @date 2022/10/23 17:41
 */
public class T226_翻转二叉树 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

        输入：root = [4,2,7,1,3,6,9]
        输出：[4,7,2,9,6,3,1]
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    /**
     * 解法一：递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 解法二：迭代
     * BFS
     */
    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size -- > 0){
                TreeNode node = queue.peek();
                queue.poll();
                swap(node);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }


    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
