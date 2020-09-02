package Trees_and_Graphs;
import java.util.*;
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

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

public class BinaryTreeFromInorderAndPostOrderTraversals {
    private int postIndex;
    private int[] postOrder;
    Map<Integer, Integer> indices = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) return null;
        
        this.postOrder = postorder;
        this.postIndex = inorder.length - 1;
        int index = 0;
        for (int key : inorder) {
            this.indices.put(key, index);
            index++;
        }
        return helper(0, inorder.length - 1);
    }
    
    private TreeNode helper(int left, int right) {
        if (left > right) return null;
        
        int rootVal = this.postOrder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        
        int index = this.indices.get(rootVal);
        postIndex -= 1;
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);
        return root;
    }
}