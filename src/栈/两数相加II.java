package 栈;

import util.ListNode;

import java.util.Stack;

public class 两数相加II {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 或 l2 为空
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // l1 l2 不为空
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        do {
            stack1.push(l1.val);
            l1 = l1.next;
        } while (l1 != null);
        do {
            stack2.push(l2.val);
            l2 = l2.next;
        } while (l2 != null);
        int flag = 0;
        ListNode head = null;
        while (!stack1.empty() || !stack2.empty() || flag > 0) {
            int sum = flag;
            sum += stack1.empty() ? 0 : stack1.pop();
            sum += stack2.empty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            flag = sum / 10;
        }
        return head;
    }

}
