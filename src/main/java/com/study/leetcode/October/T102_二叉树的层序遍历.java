package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author c
 * @date 2022/10/22 15:56
 */
public class T102_二叉树的层序遍历 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目： https://leetcode.cn/problems/binary-tree-level-order-traversal/
        给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
    --------------------------------------------------------------------------------
    解题思路：
        层序遍历
    --------------------------------------------------------------------------------
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return result;
    }
}
