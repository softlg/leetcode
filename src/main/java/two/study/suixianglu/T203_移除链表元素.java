package two.study.suixianglu;

import com.study.leetcode.util.ListNode;

/**
 * @author c
 */
public class T203_移除链表元素 {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 6, 3, 4, 5, 6};

        ListNode head = null;
        ListNode tail = null;

        for (int value : values) {
            ListNode newNode = new ListNode(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        // 打印链表
        ListNode current = head;
        System.out.println(removeElements(current, 3));
    }

}
