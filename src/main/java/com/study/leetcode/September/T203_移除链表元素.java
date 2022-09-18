package com.study.leetcode.September;

//import com.study.leetcode.util.ListNode;
//
//import java.util.List;

import com.study.leetcode.util.ListNode;

/**
 * @author：c
 * Date：2022/9/14
 */
public class T203_移除链表元素 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
        给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val){
            head = head.next;
        }
        ListNode curr = head;
        while(curr!=null){
            while(curr.next!=null && curr.next.val == val){
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
