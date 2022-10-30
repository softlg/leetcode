package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author c
 * @date 2022/10/29 21:40
 */
public class T257_二叉树的所有路径 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

        叶子节点 是指没有子节点的节点。

        输入：root = [1,2,3,null,5]
        输出：["1->2->5","1->3"]
    --------------------------------------------------------------------------------
    解题思路：
        解法一： 递归+回溯
        解法二：迭代
    --------------------------------------------------------------------------------
     */

    /**
     * 解法一：递归+回溯
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        //
        if(root == null){
            return null;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root,paths,result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> paths, List<String> result){
        if(root == null){
            return;
        }
        paths.add(root.val);
        if(root.left == null && root.right == null){
            // 输出
            result.add(getNext(paths));
            return;
        }
        if(root.left != null){
            traversal(root.left,paths,result);
            // 回溯
            paths.remove(paths.size() - 1);
        }
        if(root.right != null){
            traversal(root.right,paths,result);
            // 回溯
            paths.remove(paths.size() - 1);
        }
    }

    public String getNext(List<Integer> paths){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < paths.size() - 1; i++){
            sb.append(paths.get(i)).append("->");
        }
        sb.append(paths.get(paths.size() - 1));
        return sb.toString();
    }

    /**
     * 迭代法
     */
    public List<String> binaryTreePathsDieDai(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<Object> stack = new Stack<>();
        // 节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return result;
    }
}
