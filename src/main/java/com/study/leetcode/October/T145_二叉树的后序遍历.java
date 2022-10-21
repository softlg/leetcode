package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.*;

/**
 * @author： liaoguang
 * @date： 2022/10/20
 * Description：
 */
public class T145_二叉树的后序遍历 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
    --------------------------------------------------------------------------------
    解题思路：
        1、确定递归函数的参数和返回值： 确定哪些参数是递归的过程中需要处理的，那么就在递归函数里加上这个参数，
        并且还要明确每次递归的返回值是什么进而确定递归函数的返回类型。

        2、确定终止条件： 写完了递归算法, 运行的时候，经常会遇到栈溢出的错误，就是没写终止条件或者终止条件写的
        不对，操作系统也是用一个栈的结构来保存每一层递归的信息，如果递归没有终止，操作系统的内存栈必然就会溢出。

        3、确定单层递归的逻辑： 确定每一层递归需要处理的信息。在这里也就会重复调用自己来实现递归的过程。
    --------------------------------------------------------------------------------
    */
    /**
     * 解法一：递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorder(root,result);

        return result;
    }

    public void preorder(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        preorder(node.left,result);
        preorder(node.right,result);
        result.add(node.val);
    }

    /**
     * 解法二：迭代
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null){
                continue;
            }
            result.add(node.val);
            //
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }
}
