package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author c
 * @date 2022/10/23 17:16
 */
public class T111_二叉树的最小深度 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
       给定一个二叉树，找出其最小深度。

        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

        说明：叶子节点是指没有子节点的节点。

    --------------------------------------------------------------------------------
    解题思路：
        层序遍历
    --------------------------------------------------------------------------------
     */

    public int minDepth(TreeNode root) {
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
                if (node.left == null && node.right ==null){
                    return result += 1;
                }
            }
            result++;
        }
        return result;
    }
}
