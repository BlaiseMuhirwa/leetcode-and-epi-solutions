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
/*
Given a binary tree, return all root-to-leaf paths.
Note: A leaf is a node with no children.

Example:
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/
class Solution {
    List<String> paths = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        findPaths(root, paths, sb);
        return paths;
    }
    
    private void findPaths(TreeNode root, List<String> paths, 
                                   StringBuilder sb) {
        if (root != null) {
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                paths.add(sb.toString());
            } else {
                sb.append("->");
                String cache = sb.toString();
                findPaths(root.left, paths, sb);
                findPaths(root.right, paths, new StringBuilder(cache));
            }
        }
    }
}