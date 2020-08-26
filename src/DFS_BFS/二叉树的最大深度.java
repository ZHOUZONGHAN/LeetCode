package DFS_BFS;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author zhouzh6
 * @date 2020-07-28
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class 二叉树的最大深度 {
    static int maxLevel = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        System.out.println(BFS(root));
        DFS(root, 1);
        System.out.println(maxLevel);
    }

    public static int BFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ++res;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return res;
    }

    public static void DFS(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level > maxLevel) {
            maxLevel = level;
        }

        DFS(node.left, level + 1);
        DFS(node.right, level + 1);
    }
}
