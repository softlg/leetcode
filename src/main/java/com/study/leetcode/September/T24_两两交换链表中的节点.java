package com.study.leetcode.September;

import com.study.leetcode.util.ListNode;

/**
 * @author：c
 * Date：2022/9/18
 */
public class T24_两两交换链表中的节点 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    --------------------------------------------------------------------------------
    解题思路：
        虚拟头节点
    --------------------------------------------------------------------------------
     */

    public static ListNode swapPairs(ListNode head) {
        ListNode dumyHead = new ListNode(0);
        dumyHead.next = head;
        ListNode cur = dumyHead;

        while(cur.next != null && cur.next.next != null){
            // 临时节点
            ListNode temp = cur.next;
//            ListNode temp2 = cur.next.next.next;
            //
            cur.next = cur.next.next;
            cur.next.next = temp;
//            temp.next = temp2;
            cur = cur.next.next;

        }
        return cur.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(12345);
        System.out.println(swapPairs(listNode));
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs3(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}
