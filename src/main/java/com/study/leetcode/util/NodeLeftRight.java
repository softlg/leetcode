package com.study.leetcode.util;

/**
 * @author c
 * @date 2022/10/23 15:17
 */
public class NodeLeftRight {
    public int val;
    public NodeLeftRight left;
    public NodeLeftRight right;
    public NodeLeftRight next;

    public NodeLeftRight() {}

    public NodeLeftRight(int _val) {
        val = _val;
    }

    public NodeLeftRight(int _val, NodeLeftRight _left, NodeLeftRight _right, NodeLeftRight _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
