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
 * 
 * Given a binary tree, imagine yourself standing on the right side 
 * of it, return the values of the nodes you can see ordered from top to bottom.
 */
class Solution {
    /* this solution uses BFS with two queues. We go in level-order traversal
        otherwise known as pre-order traversal.
        The key to this problem is to realize that the right side view is always
        the last element at every level, which is why BFS is the right candidate 
        for this problem */
        
    private List<Integer> rightSide = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return rightSide;
        }
        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        nextLevel.add(root);
        while (!nextLevel.isEmpty()) {
            currentLevel = (LinkedList)nextLevel.clone();
            nextLevel.clear();
            TreeNode node = null;
            while (!currentLevel.isEmpty()) {
                node = currentLevel.remove();
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            rightSide.add(node.val);
        }
        return rightSide;
    }
}