package 链表;

import util.ListNode;

/**
 * @author zhouzh6
 * @date 2020-10-27
 */
public class K个一组翻转链表 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            // 剩余数量小于k的话，则不需要反转
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
