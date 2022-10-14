package com.study.leetcode.October;

import com.study.leetcode.util.ListNode;

/**
 * @author c
 * @date 2022/10/14 20:49
 */
public class T19_删除链表的倒数第N个结点 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
           给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    --------------------------------------------------------------------------------
    解题思路：
        1、定义fast指针和slow指针，初始值为虚拟头结点
        2、fast首先走n + 1步 ，为什么是n+1呢，因为只有这样同时移动的时候slow才能指向删除节点的上一个节点（方便做删除操作）
        3、fast和slow同时移动，直到fast指向末尾
        4、删除slow指向的下一个节点
    --------------------------------------------------------------------------------
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义虚拟头
        ListNode dumyHead = new ListNode(-1);
        dumyHead.next = head;
        // 定义快慢指针
        ListNode fast = dumyHead;
        ListNode slow = dumyHead;
        while(n-- > 0){
            fast = fast.next;
        }
        // 记住 待删除节点slow 的上一节点
        ListNode temp = null;
        while(fast != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
        temp.next = slow.next;
        // 释放 待删除节点slow 的next指针, 这句删掉也能AC
        slow.next = null;
        return dumyHead.next;
    }
}
