package Trees_and_Graphs;
import java.util.*;
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
public class BinaryTreeLevelOrderTraversal {
    /* In this algorithm we proceed by adding a list of values at every level in the tree
        provided that the value is not null. The current level is exactly equal to the length
        of the levels list. This allows us to add values corresponding to the same level in the 
        same list. Notice that this algorithm runs in O(n) time since we process each node 
        exactly once, and it takes O(n) space.
    */
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        helper(root, 0);
        return levels;
    
    }
    private void helper(TreeNode root, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList());
        }
        levels.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level+1);
        }
        if (root.right != null) {
            helper(root.right, level+1);
        }
    }
}