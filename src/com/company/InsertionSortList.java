package com.company;

public class InsertionSortList {
    /**
     * Sort a linked list using insertion sort.
     * **/
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode cur = head;
        ListNode temp = null, prev = null;
        while (cur!=null && cur.next!=null){
            if (cur.val<=cur.next.val){
                cur=cur.next;
            }
            else {
                temp=cur.next;
                cur.next=temp.next;
                prev=dummy;
                while (prev.next.val<temp.val){
                    prev=prev.next;
                }
                temp.next=prev.next;
                prev.next=temp;
            }
        }
        return dummy.next;
    }
}
