package 链表;

import util.ListNode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class 合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode ansHead = new ListNode(0);
        ListNode curNode = ansHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curNode.next = l2;
                l2 = l2.next;
            } else {
                curNode.next = l1;
                l1 = l1.next;
            }
            curNode = curNode.next;
        }

        curNode.next = l1 == null ? l2 : l1;

//        if (l1 != null) {
//            curNode.next = l1;
//        } else {
//            curNode.next = l2;
//        }

        return ansHead.next;
    }
}
