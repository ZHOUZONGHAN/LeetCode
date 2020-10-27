package 链表;

import util.ListNode;

/**
 * @author zhouzh6
 * @date 2020-10-26
 */
public class 环形链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast!= null && slow == fast) {
                return true;
            }
        }
        return false;
    }
}
