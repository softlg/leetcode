package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author c
 * @date 2022/10/23 17:16
 */
public class T104_二叉树的最大深度 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个二叉树，找出其最大深度。

        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

        说明: 叶子节点是指没有子节点的节点。
    --------------------------------------------------------------------------------
    解题思路：
        层序遍历
    --------------------------------------------------------------------------------
     */

    public int maxDepth(TreeNode root) {
        int result = 0;
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.peek();
                queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result++;
        }
        return result;
    }
}
