
import java.util.Set;
import java.util.HashSet;
/**
 * Input: Given head pointers of two singly-linked lists
 * Find :
 *      - If the lists intersect?
 *      - If the lists intersect, find the intersection node.
 *
 * Solution: 1. One performance-efficient way we can answer both of these questions is by using
 *              a set. We store references of all nodes in a set, and we iterate
 *              through the second list. If we come across a node reference that's already
 *              in the set, we return that node reference. Otherwise we return null.
 *
 *              Time complexity: O(n + m) where n and m are the lengths of the lists
 *              Space complexity: O(n) - since we are choosing to store node pointers of the
 *              first list.
 *
 *            2. If we knew that the lists always intersect, there would be a second solution
 *            that can optimize for space up to O(1). We can use two node pointers and iterate
 *            simultaneously through the lists. Once we hit the end of one list, we set the
 *            current traversing pointer to the beginning of the other and vice versa.
 *
 *            Time complexity: O(n + m)
 *            Space complexity: O(1)
 *
 */
class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {
        this.val  = val;
        this.next = null;
    }
}

public class Solution {
    /* first implementation using a set */
    public ListNode findIntersectionI(ListNode listA, ListNode listB) {
        if (listA == null || listB == null) return null;

        Set<ListNode> set = new HashSet<>();
        ListNode tempA = listA;
        ListNode tempB = listB;
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }

        while (tempB != null) {
            if (set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }

    /* second implementation that uses two node pointers. Optimizes for space if we
    * are guaranteed that the intersection exists */
    public ListNode findIntersectionII(ListNode listA, ListNode listB) {
        if (listA == null || listB == null) return null;

        ListNode tempA = listA;
        ListNode tempB = listB;
        while (tempA != tempB) {
            if (tempA != null) {
                tempA = tempA.next;
            } else tempA = listB;

            if (tempB != null) {
                tempB = tempB.next;
            } else tempB = listA;
        }
        return tempA;
    }
}

