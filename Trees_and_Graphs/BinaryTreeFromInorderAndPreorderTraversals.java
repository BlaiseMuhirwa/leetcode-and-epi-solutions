package Trees_and_Graphs;
import java.util.*;
/*
Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
*/

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeFromInorderAndPreorderTraversals {
    private int[] preOrder;
    private int preIndex;
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if (preorder == null || preorder.length == 0)
            return root;

        this.preOrder = preorder;
        int index = 0;
        for (int val : inorder) {
            this.indexMap.put(val, index);
            index++;
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int left, int right) {
        if (left == right)
            return null;
        int rootVal = preOrder[preIndex];
        TreeNode root = new TreeNode(rootVal);

        preIndex += 1;
        int index = this.indexMap.get(rootVal);
        root.left = helper(left, index);
        root.right = helper(index + 1, right);

        return root;
    }
}