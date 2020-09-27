package Linked_List;
import java.util.*;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    /**
     * Time complexity: O(n * logK) where K is the size of lists and n is the number of
     * linked list nodes
     * Space complexity: O(n) since n >= k
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode output = new ListNode(0);
        ListNode temp = output;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> a.val - b.val);

        for (ListNode current : lists) {
            if (current != null) minHeap.add(current);
        }

        while (minHeap.size() > 0) {
            ListNode current = minHeap.poll();
            if (current.next != null) {
                minHeap.add(current.next);
            }
            temp.next = new ListNode(current.val);
            temp = temp.next;
        }
        return output.next;
    }
}
