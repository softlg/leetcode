package com.study.leetcode.October;

import com.study.leetcode.util.NodeLeftRight;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author c
 * @date 2022/10/23 15:09
 */
public class T116_填充每个节点的下一个右侧节点指针 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

                struct Node {
                  int val;
                  Node *left;
                  Node *right;
                  Node *next;
                }
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

        初始状态下，所有 next 指针都被设置为 NULL。

        链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node

    示例：
        输入：root = [1,2,3,4,5,6,7]
        输出：[1,#,2,3,#,4,5,6,7,#]
        解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出
        按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。

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
        NodeLeftRight node = new NodeLeftRight(1);
        NodeLeftRight a = new NodeLeftRight(2);
        NodeLeftRight b = new NodeLeftRight(3);
        NodeLeftRight c = new NodeLeftRight(4);
        NodeLeftRight d = new NodeLeftRight(5);
        NodeLeftRight e = new NodeLeftRight(6);
        NodeLeftRight f = new NodeLeftRight(7);

        node.left = a;
        node.right = b;
        node.left.left = c;
        node.left.right = d;

        node.right.left = e;
        node.right.right = f;
        System.out.println(connect(node));
    }
}
