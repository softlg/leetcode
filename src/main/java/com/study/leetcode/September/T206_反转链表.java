package com.study.leetcode.September;

import com.study.leetcode.util.ListNode;

/**
 * @author：c
 * Date：2022/9/18
 */
public class T206_反转链表 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
        给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    --------------------------------------------------------------------------------
    解题思路：
        1、双指针
        2、递归
    --------------------------------------------------------------------------------
     */

    /**
     * 解法一：双指针
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(12345);
        System.out.println(reverseList(listNode));
    }

    /**
     * 解法二：递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
    }

}
