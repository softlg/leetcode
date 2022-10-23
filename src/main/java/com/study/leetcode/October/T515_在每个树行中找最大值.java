package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author c
 * @date 2022/10/23 14:12
 */
public class T515_在每个树行中找最大值 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
    --------------------------------------------------------------------------------
    解题思路：
        层序遍历
    --------------------------------------------------------------------------------
     */

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size(), max = deque.peek().val;
            while(size-- > 0){
                TreeNode node = deque.poll();
                max = Math.max(max,node.val);
                if(node.left != null){
                    // 避坑 deque.push()用于当deque当成栈使用的时候调用
                    deque.offer(node.left);
                }
                if(node.right != null){
                    deque.offer(node.right);
                }

            }
            result.add(max);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(9);

        node.left = a;
        node.right = b;
        node.left.left = c;
        node.left.right = d;
        node.right.right = e;


        System.out.println(largestValues(node));
    }
}
