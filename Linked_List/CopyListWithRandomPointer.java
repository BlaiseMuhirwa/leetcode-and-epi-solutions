package Linked_List;
import java.util.*;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    /* hashmap which contains old nodes as keys and new nodes as values */
    Map<Node, Node> visited = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        if (visited.containsKey(head)) {
            return visited.get(head);
        }

        Node copy = new Node(head.val);
        visited.put(head, copy);

        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        return copy;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
