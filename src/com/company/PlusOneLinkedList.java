package com.company;
// TAG: LinkedList
public class PlusOneLinkedList {
    private int carry=0;

    /**
     * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.

     Example:
     Input:
     1->2->3

     Output:
     1->2->4
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        helper(head);
        if (carry!=0) {
            dummy.val=carry;
            return dummy;
        }
        return dummy.next;
    }
    private void helper(ListNode head){
        if (head.next==null){
            int sum = head.val+1;
            head.val = sum%10;
            carry = sum/10;
            return;
        }
        helper(head.next);
        int p = head.val+carry;
        head.val = p%10;
        carry=p/10;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
