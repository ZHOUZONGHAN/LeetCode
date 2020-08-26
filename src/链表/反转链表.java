package 链表;

import util.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */



public class 反转链表 {
    public static ListNode ReverseList(ListNode head) {
        ListNode next,pre;
        next = pre = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        ListNode node = null;
        for (int i = 2; i < 11; i++) {
            node = new ListNode(i);
            temp.next = node;
            temp = temp.next;
        }
        head = ReverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
