package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author c
 * @date 2022/10/29 20:22
 */
public class T222_完全二叉树的节点个数 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

        完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
        并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            num += size;
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
        }
        return num;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);

        node.left = a;
        node.right = b;
        node.left.left = c;
        node.left.right = d;
        node.right.left = e;

        System.out.println(countNodes(node));
    }
}
