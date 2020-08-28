package Linked_List;

/*
 * Reverse a singly linked list.
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = null;
        ListNode next = null;
        ListNode temp = head;
        
        while (temp != null) {
            next = temp.next;
            current = temp;
            current.next = previous;
            previous = temp;
            temp = next;
        }
        return current;
    }
}