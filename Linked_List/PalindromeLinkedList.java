package linked_list;


// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 


public class PalindromeLinkedList {
    /* This algorithm runs in O(n) time with O(1) extra space */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode middle = middleNode(head);
        ListNode reversedHalf = reverseSecondHalf(middle.next);

        while (reversedHalf != null) {
            if (head.val != reversedHalf.val) {
                return false;
            }
            reversedHalf = reversedHalf.next;
            head = head.next;
        }
        return true;
     
    }
    private ListNode middleNode(ListNode head) {
        /* use the two-pointer strategy */
        ListNode pt1 = head;
        ListNode pt2 = head;
        while (pt2 != null) {
            if (pt2.next == null || pt2.next.next == null) {
                return pt1;
            }
            pt1 = pt1.next;
            pt2 = pt2.next.next;
        }
        return pt1;
    }
    private ListNode reverseSecondHalf(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode temp = head;
        while (temp != null) {
            next = temp.next; /* save the next node */
            temp.next = prev; /* reverse */
            prev = temp;
            temp = next;
        }
        return prev;
    }
}