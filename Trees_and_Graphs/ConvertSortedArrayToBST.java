package Trees_and_Graphs;

public class ConvertSortedArrayToBST {
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
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;

        int midPoint = (start + end) / 2;

        TreeNode root = new TreeNode(nums[midPoint]);
        root.left = helper(nums, start, midPoint - 1);
        root.right = helper(nums, midPoint + 1, end);
        return root;
    }
    
}
}