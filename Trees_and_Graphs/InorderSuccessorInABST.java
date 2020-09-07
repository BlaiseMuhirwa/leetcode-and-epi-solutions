package Trees_and_Graphs;
import java.util.*;

public class InorderSuccessorInABST {
    Map<Integer, TreeNode> map = new LinkedHashMap<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        int index = 0;
        List<Integer> keys = new ArrayList(map.keySet());
        if (keys.get(keys.size() - 1) == p.val) return null;
        Iterator<Integer> iter = keys.listIterator();
        TreeNode output = null;
        while (iter.hasNext()) {
            int key = iter.next();
            if (key == p.val) {
                int successor = iter.next();
                output = map.get(successor);
                break;
            }
        }
        return output;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) dfs(root.left);
        map.put(root.val, root);
        if (root.right != null) dfs(root.right);
    }
}
