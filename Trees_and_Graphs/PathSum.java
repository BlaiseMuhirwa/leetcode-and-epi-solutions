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

 /*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
 all the values along the path equals the given sum.
Note: A leaf is a node with no children.
*/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null &&
           sum == 0) {
            return true;
        }
        return hasPathSum(root.left, sum) ||
            hasPathSum(root.right, sum);
    }
}