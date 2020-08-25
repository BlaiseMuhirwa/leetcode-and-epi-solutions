package Trees_and_Graphs;
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

/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
Example:
    Given binary tree [3,9,20,null,null,15,7],
        3
        / \
        9  20
            /  \
            15   7
    output: 2
*/
public class MinDepth {
    int minLength = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        if (root.left != null) {
            minLength = Math.min(minLength, minDepth(root.left));
        }
        if (root.right != null) {
            minLength = Math.min(minLength, minDepth(root.right));
        }
        return minLength+1;
    }
}

/* iterative solution 
public class MinDepth {
        int minLength = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        
        stack.add(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            int value = current.getValue();
            root = current.getKey();
            if (root.left == null && root.right == null) {
                minLength = Math.min(minLength, value);
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, value+1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, value+1));
            }
        }
        return minLength;
    }
}

*/