package com.study.leetcode.util;

/**
 * 类名 ：Java类就是一种自定义的数据结构
 * @author c
 * 2022.09.07
 */
public class ListNode {

    /**
     * 成员变量：数值
     */
    public int val;
    /**
     * 对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似
     */
    public ListNode next;

    /**
     * 一个参数的构造方法
     */
    public ListNode(int val){
        // 把接收的参数赋值给当前类的val变量
        this.val=val;
    }

    public ListNode(int val, ListNode next) {
        // 这个就是包含两个参数的构造方法
        this.val = val;
        this.next = next;
    }

}
