package com.study.leetcode.October;

import com.study.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author c
 * @date 2022/10/30 20:40
 */
public class T100_相同的树 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    --------------------------------------------------------------------------------
    解题思路：
        解法一：迭代
        解法二：递归
    --------------------------------------------------------------------------------
     */

    /**
     * 迭代
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return getNode(p).equals(getNode(q));
    }

    public List<Integer> getNode(TreeNode node){
        List<Integer> res = new ArrayList<>();
        if(node == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode treeNode = queue.peek();
                res.add(treeNode.val);
                queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    /**
     * 递归
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null) {
            return false;
        }

        if(p.val != q.val){
            return false;
        }
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }

}
