package Trees_and_Graphs;
import java.util.*;

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
public class BSTIterator {
    List<Integer> sortedNodes;
    int index;
    public BSTIterator(TreeNode root) {
        this.sortedNodes = new ArrayList<>();
        this.index = 0;
        inorderTraversal(root);
    }
    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        this.sortedNodes.add(root.val);
        inorderTraversal(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return this.sortedNodes.get(index++);

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index < this.sortedNodes.size();
    }
}
