package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.*;

/**
 * @author c
 * @date 2022/10/22 16:16
 */
public class T107_二叉树的层序遍历II {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目： https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
        给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    --------------------------------------------------------------------------------
    解题思路：
        层序遍历
    --------------------------------------------------------------------------------
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 如果root非空，放入队列
        if(root != null){
            queue.add(root);
        }
        // 循环
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.peek();
                queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }

}
