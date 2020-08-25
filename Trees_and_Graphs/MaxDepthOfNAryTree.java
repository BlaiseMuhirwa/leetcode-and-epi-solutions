package Trees_and_Graphs;
import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/*
Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down
to the farthest leaf node.
Nary-Tree input serialization is represented in their level order traversal, each group
of children is separated by the null value (See examples).

Input: root = [1,null,3,2,4,null,5,6]
Output: 3
*/
public class MaxDepthOfNAryTree {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        LinkedList<Pair<Node, Integer>> stack = new LinkedList<>();
        
        stack.push(new Pair(root, 1));
        int maxDepth = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.poll();
            root = current.getKey();
            int value = current.getValue();
            if (root.children == null) {
                maxDepth = Math.max(maxDepth, value);
            }
            else {
                maxDepth = Math.max(maxDepth, value);
                Iterator<Node> iter = root.children.listIterator();
                while (iter.hasNext()) {
                    stack.push(new Pair(iter.next(), value+1));
                }
            }
        }
        return maxDepth;
    }
}