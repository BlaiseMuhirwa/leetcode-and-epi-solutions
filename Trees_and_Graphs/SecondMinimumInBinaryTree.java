package Trees_and_Graphs;
import java.util.*;


public class SecondMinimumInBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        Set<Integer> values = new HashSet<>();
        helper(root, values);

        List<Integer> list = new ArrayList<>();
        int firstMin = root.val;
        int secondMin = root.val;
        for (int val : values) {
            list.add(val);
        }
        Collections.sort(list);
        if (list.size() > 1) return list.get(1);
        return -1;

    }

    void helper(TreeNode root, Set<Integer> values) {
        if (root != null) {
            values.add(root.val);
        }
        if (root.left != null) helper(root.left, values);
        if (root.right != null) helper(root.right, values);

    }
}
