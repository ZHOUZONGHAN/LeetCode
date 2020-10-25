package 树;

import util.TreeNode;

import java.util.Arrays;

/**
 * @author zhouzh6
 * @date 2020-09-26
 */
public class 中序后序构建二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        if (inorder.length != postorder.length) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postorder.length - 1]);

        int index = 0;
        for (int i = 0; i < postorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                index = i;
                break;
            }
        }

        node.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));

        return node;
    }
}
