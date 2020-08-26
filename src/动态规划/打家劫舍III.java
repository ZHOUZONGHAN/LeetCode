package 动态规划;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]    输出: 7
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]   输出: 9
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 */
public class 打家劫舍III {

    private Map<TreeNode, Integer> f = new HashMap<>();
    private Map<TreeNode, Integer> g = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        打家劫舍III test = new 打家劫舍III();
        System.out.println(test.rob(root));
    }

    public int rob(TreeNode root) {
//        dfs(root);
//        int res = Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
        int[] dfs2 = dfs2(root);
        int res2 = Math.max(dfs2[0], dfs2[1]);
        return res2;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;

        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

    public int[] dfs2(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs2(node.left);
        int[] right = dfs2(node.right);

        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];

        return res;
    }

}
