package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author c
 * @date 2022/10/22 17:01
 */
public class T637_二叉树的层平均值 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 循环
        while(!queue.isEmpty()){
            int size = queue.size();
            double count = 0;
            int s = size;
            while(size-- > 0){
                TreeNode node = queue.peek();
                queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                count += node.val;
            }
            double a = count / s;
            result.add(a);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);

        node.left = a;
        node.right = b;
        node.right.left = c;
        node.right.right = d;

        System.out.println(averageOfLevels(node));
    }
}
