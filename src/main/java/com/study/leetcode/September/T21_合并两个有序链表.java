package com.study.leetcode.September;

import com.study.leetcode.util.ListNode;

/**
 * @author c
 * 2022/9/7
 */
public class T21_合并两个有序链表 {
    /*
    难度：简单
    --------------------------------------------------------------------------------
    题目：
       将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

    --------------------------------------------------------------------------------
    解题思路：


    --------------------------------------------------------------------------------
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //     if(list1 == null){
        //         return list2;
        //     }
        //      if(list2 == null){
        //         return list1;
        //     }
        //     if(list1.val < list2.val){
        //         list1.next = mergeTwoLists(list1.next,list2);
        //         return list1;
        //     }else{
        //         list2.next = mergeTwoLists(list1,list2.next);
        //         return list2;
        //     }

        // }

        // 虚拟头结点   解法二：双指针
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }
}
