package Trees_and_Graphs;


 /* Definition for a binary tree node. */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


public class AllNodesDistanceKBinaryTree {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> output = new ArrayList<>();

        constructGraph(root, null);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        queue.add(new Pair(target.val, 0));
        visited.put(target.val, true);

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int node = pair.getKey();
            int level = pair.getValue();

            if (level == K) {
                output.add(node);
            }
            Iterator<Integer> iter = this.graph.get(node).listIterator();
            while (iter.hasNext()) {
                int nextValue = iter.next();
                if (!visited.containsKey(nextValue)) {
                    queue.add(new Pair(nextValue, level + 1));
                    visited.put(nextValue, true);
                }
            }
        }
        return output;

    }
    private void constructGraph(TreeNode root, TreeNode parent) {
        if (root == null) return;
        List<Integer> values = new ArrayList<>();
        if (root.left != null) values.add(root.left.val);
        if (root.right != null) values.add(root.right.val);
        if (parent != null) values.add(parent.val);
        this.graph.put(root.val, values);

        constructGraph(root.left, root);
        constructGraph(root.right, root);
    }
}
