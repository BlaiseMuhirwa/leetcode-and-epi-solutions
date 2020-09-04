package Trees_and_Graphs;
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BinaryTreeVerticalOrderTraversal {
    /** overall this algorithm runs in O(nlogn) because of sorting.
     * its space complexity is O(n)
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (root == null) return output;

        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            int column = pair.getValue();

            List<Integer> values = columnTable.getOrDefault(column, new ArrayList<>());
            values.add(root.val);
            columnTable.put(column, values);
            if (root.left != null) {
                queue.add(new Pair(root.left, column - 1));
            }
            if (root.right != null) {
                queue.add(new Pair(root.right, column + 1));
            }
        }
        List<Integer> sortedKeys = new ArrayList(columnTable.keySet());
        Collections.sort(sortedKeys);

        for (int key : sortedKeys) {
            output.add(columnTable.get(key));
        }
        return output;
    }
}
