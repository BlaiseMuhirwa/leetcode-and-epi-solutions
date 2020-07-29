package Arrays;

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

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        /* Here we use the DFS traversal.
            The time complexity of this algorithm is O(n). In the worst case, 
            the space complexity is O(n) but in the best case it is O(logn) */
        if (root == null) {
            return 0;
        } 
        else if (root.left == null && root.right == null) {
            return 1;
        }
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
        
    }
}