package Trees_and_Graphs;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 */
public class SubTreeOfAnotherTree {
    /**
     * This algorithm runs in O(m + n + m*n) where m is the number of nodes
     * in s, and n is the number of nodes in n.
     * The operation of indexOf takes O(m*n) time.
     * space complexity: O(max(m, n)) corresponding to the depth of the recursion
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }

    public String preorder(TreeNode node, boolean left) {
        if (node == null) {
            if (left) return "l";
            else return "r";
        }
        return "*" + node.val + preorder(node.left, true) + preorder(node.right, false);
    }
}
