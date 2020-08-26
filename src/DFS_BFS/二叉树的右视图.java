package DFS_BFS;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右视图 {

    /**
     * DFS
     */
    List<Integer> list = new ArrayList<>();
    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(node.val);
        }
        depth++;
        dfs(node.right, depth);
        dfs(node.left, depth);
    }
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (size - 1 == i) {
                    list.add(node.val);
                }
            }

        }
        return list;
    }
}
