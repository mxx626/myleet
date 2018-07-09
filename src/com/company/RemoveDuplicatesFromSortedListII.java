package com.company;
/**
 *  Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *  For example,
 *  Given 1->2->3->3->3->4->4->5, return 1->2->5.
 *          ptr
 *  Given 1->1->1->2->3, return 2->3
 * **/
public class RemoveDuplicatesFromSortedListII {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode ptr = dummy;
        while (ptr.next!=null && ptr.next.next!=null){
            if(ptr.next.val==ptr.next.next.val){
                int num = ptr.next.val;
                while (ptr.next!=null && ptr.next.val==num){
                    ptr.next=ptr.next.next;
                }
            }
            else {
                ptr=ptr.next;
            }
        }
        return dummy.next;
    }
    //  0->1->1->1->2->3->3->3->4->4->5, return 1->2->5.
    //  s        f
    public ListNode deleteDuplicates2(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = head;
        slow.next=fast;
        while (fast!=null){
            while (fast.next!=null && fast.val==fast.next.val){
                fast=fast.next;
            }
            if (slow.next!=fast){
                slow.next = fast.next;
                fast=fast.next;
            }
            else {
                slow=slow.next;
                fast=fast.next;
            }
        }
        return dummy.next;
    }
}
