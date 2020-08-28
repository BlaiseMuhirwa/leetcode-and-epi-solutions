package Linked_List;

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

 /*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode copy = new ListNode (0, l1);
        ListNode reversedFirst = reverseList(l1);
        ListNode reversedSecond = reverseList(l2);
        
        StringBuilder firstNum = new StringBuilder();
        StringBuilder secondNum = new StringBuilder();
        
        while (reversedFirst != null) {
            firstNum.append(""+reversedFirst.val);
            reversedFirst = reversedFirst.next;
        }
        while (reversedSecond != null) {
            secondNum.append(""+reversedSecond.val);
            reversedSecond = reversedSecond.next;
        }
        int result = Integer.parseInt(firstNum.toString()) +
            Integer.parseInt(secondNum.toString());
        
        String output = Integer.toString(result);
        ListNode ret = new ListNode(0);
        ListNode curr = ret;
        for (int i = output.length() - 1; i >= 0; i--) {
            char ch = output.charAt(i);
            int value = Character.getNumericValue(ch);
            curr.next = new ListNode(value);
            curr = curr.next;
            
        }
        return ret.next;

    }
    
    private ListNode reverseList(ListNode list) {
        ListNode previous = null;
        ListNode current = null;
        ListNode next = null;
        ListNode temp = list;
        
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