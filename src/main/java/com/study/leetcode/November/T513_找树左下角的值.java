package com.study.leetcode.November;

import com.study.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author c
 * @date 2022/11/2 22:00
 */
public class T513_找树左下角的值 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。

        假设二叉树中至少有一个节点。
    --------------------------------------------------------------------------------
    解题思路：
        层序遍历
    --------------------------------------------------------------------------------
     */

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }
}
