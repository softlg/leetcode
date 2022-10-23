package com.study.leetcode.October;

import com.study.leetcode.util.NodeLeftRight;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author c
 * @date 2022/10/23 17:04
 */
public class T117_填充每个节点的下一个右侧节点指针II {
       /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
       给定一个二叉树
            struct Node {
              int val;
              Node *left;
              Node *right;
              Node *next;
            }
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

        初始状态下，所有 next 指针都被设置为 NULL。

        链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii

    示例：

        输入：root = [1,2,3,4,5,null,7]
        输出：[1,#,2,3,#,4,5,7,#]
        解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
        序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。


    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static NodeLeftRight connect(NodeLeftRight root) {
        Deque<NodeLeftRight> deque = new ArrayDeque<>();
        if(root != null){
            deque.add(root);
        }
        while(!deque.isEmpty()){
            int size = deque.size();
            NodeLeftRight cur = deque.poll();
            if (cur.left != null){
                deque.add(cur.left);
            }
            if (cur.right != null){
                deque.add(cur.right);
            }

            for (int i = 1; i < size; i++) {
                NodeLeftRight node = deque.poll();
                if(node.left != null){
                    deque.add(node.left);
                }
                if(node.right != null){
                    deque.add(node.right);
                }
                cur.next = node;
                cur = node;
            }
        }
        return root;
    }


    public static void main(String[] args) {

    }
}
