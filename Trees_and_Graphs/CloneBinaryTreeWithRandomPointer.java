package Trees_and_Graphs;
import java.util.*;


/**
 * A binary tree is given such that each node contains an additional
 * random pointer which could point to any node in the tree or null.
 *
 * Return a deep copy of the tree.
 */
public class CloneBinaryTreeWithRandomPointer {
    Map<Node, NodeCopy> visited = new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) return null;

        if (visited.containsKey(root)) {
            return visited.get(root);
        }

        NodeCopy clone = new NodeCopy(root.val, null, null, null);
        visited.put(root, clone);

        if (root.left != null) {
            clone.left = copyRandomBinaryTree(root.left);
        }

        if (root.right != null) {
            clone.right = copyRandomBinaryTree(root.right);
        }

        if (root.random != null) {
            clone.random = copyRandomBinaryTree(root.random);
        }
        return clone;
    }


 public class Node {
      int val;
      Node left;
      Node right;
      Node random;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node left, Node right, Node random) {
          this.val = val;
          this.left = left;
          this.right = right;
          this.random = random;
      }
  }
}
