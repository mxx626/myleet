package com.company;

public class SortList {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     * **/
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode middle = getMiddle(head);
        ListNode secondHead = middle.next;
        middle.next=null;
        return merge(sortList(head), sortList(secondHead));
    }
    private ListNode getMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode first, ListNode second){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (first!=null && second!=null){
            if (first.val<=second.val){
                cur.next=first;
                first=first.next;
            }
            else{
                cur.next=second;
                second=second.next;
            }
            cur=cur.next;
        }
        if (first==null) cur.next=second;
        else cur.next=first;
        return dummy.next;
    }
}
