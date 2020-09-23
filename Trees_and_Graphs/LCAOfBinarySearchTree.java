package Trees_and_Graphs;
import java.util.*;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 */
public class LCAOfBinarySearchTree {
    List<TreeNode> listq = new ArrayList<>();
    Set<TreeNode> set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null) return q;
        if (q == null) return p;

        findPath(root, p);
        findPath(listq, root, q);
        Collections.reverse(listq);

        for (TreeNode node : listq) {
            if (set.contains(node)) return node;
        }
        return null;
    }

    public void findPath(TreeNode root, TreeNode query) {
        if (root == null) return;
        if (root.val == query.val) {
            set.add(query);
            return;
        }
        if (root != null) {
            set.add(root);
        }
        if (root.val > query.val) {
            findPath(root.left, query);
        } else {
            findPath(root.right, query);
        }
    }

    public void findPath(List<TreeNode> listq, TreeNode root, TreeNode query) {
        if (root == null) return;
        if (root.val == query.val) {
            listq.add(query);
            return;
        }
        if (root != null) {
            listq.add(root);
        }
        if (root.val > query.val) {
            findPath(listq, root.left, query);
        } else {
            findPath(listq, root.right, query);
        }
    }
}
