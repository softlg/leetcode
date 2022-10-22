package com.study.leetcode.October;

import com.study.leetcode.util.Node;

import java.util.*;

/**
 * @author c
 * @date 2022/10/22 21:13
 */
public class T429_N叉树的层序遍历 {
    /*
    难度：
    --------------------------------------------------------------------------------
    题目：
        给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。

        树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
    示例：
        输入：root = [1,null,3,2,4,null,5,6]
        输出：[[1],[3,2,4],[5,6]]
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        //
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            while(size-- > 0){
                Node node = deque.peek();
                deque.poll();
                list.add(node.val);
                if (node.children != null){
                    List<Node> children = node.children;
                    for (int i = 0; i < children.size(); i++) {
                        deque.offer(children.get(i));
                    }
                }
            }
            result.add(list);
        }
        return result;
    }

}
