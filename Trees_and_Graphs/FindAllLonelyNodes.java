package Trees_and_Graphs;
import java.util.*;

/**
 * In a binary tree, a lonely node is a node that is the only child of its parent node.
 * The root of the tree is not lonely because it does not have a parent node.
 *
 * Given the root of a binary tree, return an array containing the values of all lonely
 * nodes in the tree. Return the list in any order.
 */
public class FindAllLonelyNodes {
    List<Integer> output = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root == null) return output;

        getLonelyChildren(root);
        return output;
    }

    public void getLonelyChildren(TreeNode parent) {
        if (parent == null) return;
        else {
            if (parent.left != null && parent.right == null) {
                output.add(parent.left.val);
            }
            else if (parent.right != null && parent.left == null) {
                output.add(parent.right.val);
            }
        }
        getLonelyChildren(parent.left);
        getLonelyChildren(parent.right);
    }
}
