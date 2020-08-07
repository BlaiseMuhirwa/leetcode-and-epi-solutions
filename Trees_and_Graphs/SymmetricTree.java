package trees_and_graphs;

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

public class SymmetricTree {
    /* The following recursive algorithm relies on the fact that two trees are symmetric iff the 
        left subtree of the first is equal to the right subtree of the second, and the right 
        subtree of the first is equal to the left subtree of the second.
        It runs in O(n) time with, worst case, O(n) space
    */
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    private boolean helper(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        
        if (t1.val == t2.val && helper(t1.right, t2.left) &&
           helper(t1.left, t2.right)) {
            return true;
        }
        else {
            return false;
        }
    }
}

/* The following is the iterative implementation 
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}
*/