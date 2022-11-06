package com.study.leetcode.November;

import com.study.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2022/11/6 16:08
 */
public class T113_路径总和II {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

        叶子节点 是指没有子节点的节点。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/path-sum-ii
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        if(root == null){
            return res;
        }
        preOrderDfs(root,targetSum, res, path);
        // return
        return res;
    }

    public void preOrderDfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path){
        path.add(root.val);
        // targetSum -= root.val;
        // 叶子结点
        if(root.left == null && root.right ==null){
            if(targetSum - root.val == 0){
                // TODO 加入的path 得重新 new ArrayList<>(path)
                res.add(new ArrayList<>(path));
            }
        }
        //
        if(root.left != null){
            preOrderDfs(root.left,targetSum - root.val,res,path);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            preOrderDfs(root.right,targetSum - root.val,res,path);
            path.remove(path.size() - 1);
        }
    }

}
