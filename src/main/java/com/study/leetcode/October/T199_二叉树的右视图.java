package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author c
 * @date 2022/10/22 16:21
 */
public class T199_二叉树的右视图 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目： https://leetcode.cn/problems/binary-tree-right-side-view/
        给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    --------------------------------------------------------------------------------
    解题思路：
        层序遍历
    --------------------------------------------------------------------------------
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 定义queue
        Queue<TreeNode> queue = new LinkedList<>();
        //
        if(root != null){
            queue.add(root);
        }
        // 循环终止
        while(!queue.isEmpty()) {
            // 记录每层size
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.peek();
                queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (size == 0) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 5;
        while(size-- > 0){
            System.out.println(111);
            if (size == 0){
                System.out.println("end");
            }
        }
    }
}
