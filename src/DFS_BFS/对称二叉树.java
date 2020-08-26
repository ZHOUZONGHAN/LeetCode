package DFS_BFS;

import util.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */

public class 对称二叉树 {

    public static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }
}
