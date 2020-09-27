package Trees_and_Graphs;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both
 * p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LCAOfBinaryTree {
    /**
     * This solution runs in O(n) time
     */
    TreeNode output = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        recurseTree(root, p, q);
        return output;
    }

    public boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) return false;

        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;

        //if the current node is one of p or q
        int mid = (currentNode.val == p.val || currentNode.val == q.val) ? 1 : 0;

        //if any of the two flags left, right, or mid are true
        if (mid + left + right >= 2) this.output = currentNode;

        //return true if any of the flags is true
        return mid + right + left > 0;

    }
}
