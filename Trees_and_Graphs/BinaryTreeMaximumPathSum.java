package Trees_and_Graphs;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maximumGain(root);
        return this.maxSum;
    }

    private int maximumGain(TreeNode root) {
        if (root == null) return 0;

        int leftGain = Math.max(maximumGain(root.left), 0);
        int rightGain = Math.max(maximumGain(root.right), 0);

        //starting a new path at the current node
        int maxAtNewPath = root.val + leftGain + rightGain;

        this.maxSum = Math.max(this.maxSum, maxAtNewPath);

        return root.val + Math.max(leftGain, rightGain);
    }
}
