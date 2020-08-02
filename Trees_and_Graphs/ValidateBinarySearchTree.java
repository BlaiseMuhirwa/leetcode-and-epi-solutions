package Trees_and_Graphs;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class ValidateBinarySearchTree {
    /* This algorithm runs in O(n) time since we check every node in the tree exactly once. 
        The space complexity is also O(n) since the call stack grows exactly n times because of recursion. 
        Idea: 
            The idea in this algorithm is to pick an upper bound and a lower bound for which to compare other values
            because it does not suffice to check if root > left and right > root (make sure you understand 
            why this is the case).
    */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer lowerLimit, Integer upperLimit) {
        if (root == null) return true;
        
        int rootValue = root.val;
        if (upperLimit != null && rootValue >= upperLimit) return false;
        if (lowerLimit != null && rootValue <= lowerLimit) return false;
        
        if (!helper(root.left, lowerLimit, rootValue)) return false;
        if (!helper(root.right, rootValue, upperLimit)) return false;
        
        return true;
    }
}