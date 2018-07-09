package com.company;
// LinkedList
public class RemoveDuplicatesfromSortedList {
    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.

     Example 1:

     Input: 1->1->2
     Output: 1->2
     Example 2:

     Input: 1->1->2->3->3
     Output: 1->2->3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode slow = dummy;
        ListNode fast = head;
        ListNode pre = head;
        while (fast!=null && fast.next!=null){
            if (fast.val!=fast.next.val){
                slow.next = fast;
                slow=slow.next;
            }
            pre = fast;
            fast=fast.next;
        }
        if (pre.val==fast.val) slow.next=fast;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
