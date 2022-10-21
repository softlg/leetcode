package com.study.leetcode.util;

import java.util.List;

/**
 * @author： liaoguang
 * @date： 2022/10/21 9:48
 * Description：
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
