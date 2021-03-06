package 剑指Offer;

import util.TreeNode;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class 重建二叉树 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int len = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                len = i;
                break;
            }
        }
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, len + 1), Arrays.copyOfRange(inorder, 0, len));
        node.right = buildTree(Arrays.copyOfRange(preorder, len + 1, preorder.length), Arrays.copyOfRange(inorder, len + 1, preorder.length));
        return node;
    }


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                //copyOfRange 函数，左闭右开
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
    }
}
