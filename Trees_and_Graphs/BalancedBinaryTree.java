package Trees_and_Graphs;

public class BalancedBinaryTree {
    /* there are two ways to solve this problem: top-down recursive approach, and the
    bottom-up recursive approach. The first takes O(nlogn) while the second one 
    takes O(n) time. Both have O(n) space compexity. 
    */
    public boolean isBalanced(TreeNode root) {
        /* an empty tree is balanced by definition */
        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left) - height(root.right)) < 2
           && isBalanced(root.left)
           && isBalanced(root.right)) {
            return true;
        }
        else {
            return false;
        }

    }
    
    private int height (TreeNode root) {
        /* an empty tree has height -1*/
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

final class TreeInfo {
    public final int height;
    public final boolean balanced;
  
    public TreeInfo(int height, boolean balanced) {
      this.height = height;
      this.balanced = balanced;
    }
  }
  
  class Solution {
    // Return whether or not the tree at root is balanced while also storing
    // the tree's height in a reference variable.
    private TreeInfo isBalancedTreeHelper(TreeNode root) {
      // An empty tree is balanced and has height = -1
      if (root == null) {
        return new TreeInfo(-1, true);
      }
  
      // Check subtrees to see if they are balanced.
      TreeInfo left = isBalancedTreeHelper(root.left);
      if (!left.balanced) {
        return new TreeInfo(-1, false);
      }
      TreeInfo right = isBalancedTreeHelper(root.right);
      if (!right.balanced) {
        return new TreeInfo(-1, false);
      }
  
      // Use the height obtained from the recursive calls to
      // determine if the current node is also balanced.
      if (Math.abs(left.height - right.height) < 2) {
        return new TreeInfo(Math.max(left.height, right.height) + 1, true);
      }
      return new TreeInfo(-1, false);
    }
  
    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }
}  