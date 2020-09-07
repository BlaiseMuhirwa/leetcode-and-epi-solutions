package Trees_and_Graphs;
import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of
 * its nodes' values. (ie, from left to right, then right to left
 * for the next level and alternate between).
 */
public class BinaryTreeZigZagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (root == null) {
            return output;
        }
        //variable indicating the direction in which we add nodes.
        boolean left = true;
        LinkedList<TreeNode> deque = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();
        deque.addLast(root);
        deque.addLast(null);

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            if (node != null) {
                if (left) current.addLast(node.val);
                else current.addFirst(node.val);

                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            } else {
                // we finish scanning one level
                output.add(current);
                current = new LinkedList<>();
                if (!deque.isEmpty()) {
                    deque.addLast(null);
                }
                left = !left;
            }

        }
        return output;

    }
}
