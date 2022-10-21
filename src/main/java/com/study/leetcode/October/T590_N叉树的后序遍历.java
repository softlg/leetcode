package com.study.leetcode.October;

import com.study.leetcode.util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： liaoguang
 * @date： 2022/10/21 9:47
 * Description：
 */
public class T590_N叉树的后序遍历 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给定一个 n叉树的根节点root，返回 其节点值的 后序遍历 。

        n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。

        输入：root = [1,null,3,2,4,null,5,6]
        输出：[5,6,3,2,4,1]
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
    */

    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;
    }
    void dfs(Node root) {
        if (root == null){
            return;
        }
        for (Node node : root.children){
            dfs(node);
        }
        ans.add(root.val);
    }
}
