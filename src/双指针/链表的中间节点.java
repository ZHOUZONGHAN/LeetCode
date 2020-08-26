package 双指针;

import util.ListNode;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class 链表的中间节点 {

//    public static ListNode middleNode(ListNode head) {
//        ListNode slow,fast;
//        slow = head;
//        fast = head;
//        if (fast.next == null) return slow;
//        while (fast != null && fast.next != null && fast.next.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        if (fast.next == null) {
//            return slow;
//        } else {
//            return slow.next;
//        }
//    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
