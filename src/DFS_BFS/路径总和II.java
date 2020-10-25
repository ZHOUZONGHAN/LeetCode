package DFS_BFS;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhouzh6
 * @date 2020-09-26
 */
public class 路径总和II {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new LinkedList<>());
        return result;
    }

    public static void dfs(TreeNode node, int sum, LinkedList<Integer> list) {
        if (node == null || sum < 0) {
            return;
        }
        list.add(node.val);
        if (sum == node.val && node.left == null && node.right == null) {
            result.add(new ArrayList<>(list));
        }
        dfs(node.left, sum - node.val, list);
        dfs(node.right, sum - node.val, list);
        list.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> lists = pathSum(root, 22);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
