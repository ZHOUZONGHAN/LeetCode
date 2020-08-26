import util.ListNode;
import util.TreeNode;

import java.util.*;

/**
 * @author zhoudawang
 */
public class Test {

    private TreeNode res;

    public static void main(String[] args) {
        Test test = new Test();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        test.flatten(root);
    }

    public void flatten(TreeNode root) {
        res = new TreeNode(root.val);
        TreeNode ans = res;
        DFS(root);
    }

    public void DFS(TreeNode node) {
        if (node.left != null) {
            res.right = new TreeNode(node.left.val);
            res = res.right;
        } else {
            return;
        }
        DFS(node.left);

        if (node.right != null) {
            res.right = new TreeNode(node.right.val);
            res = res.right;
        } else {
            return;
        }
        DFS(node.right);
    }
}
