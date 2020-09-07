package Trees_and_Graphs;
import java.util.*;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        dfs(nodes, root);
        //Collections.sort(nodes); nodes need not be sorted since we are using
        //in-order traversal anyway
        return nodes.get(k - 1);
    }

    private void dfs(List<Integer> nodes, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            dfs(nodes, root.left);
        }
        nodes.add(root.val);
        if (root.right != null) {
            dfs(nodes, root.right);
        }
    }
}
