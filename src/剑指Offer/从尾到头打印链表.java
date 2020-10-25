package 剑指Offer;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhouzh6
 * @date 2020-09-24
 */
public class 从尾到头打印链表 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        // 返回int数组
//        int[] res = new int[stack.size()];
//        int size = stack.size();
//        for (int i = 0; i < size; i++) {
//            res[i] = stack.pop();
//        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        ArrayList<Integer> arrayList = printListFromTailToHead(node1);
    }
}
