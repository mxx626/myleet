package com.company;

import java.util.List;

public class ReorderList {
    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * You must do this in-place without altering the nodes' values.
     * For example,
     * Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */
    public void reorderList2(ListNode head) {
        if (head==null || head.next==null) return;
        ListNode first=head;
        ListNode second=head;
        while (second.next!=null && second.next.next!=null){
            first=first.next;
            second = second.next.next;
        }
        ListNode mid = first;
        ListNode next = mid.next;
        while (next.next!=null){
            ListNode cur = next.next;
            next.next = cur.next;
            cur.next=mid.next;
            mid.next=cur;
        }
        first=head;
        ListNode secondHead = mid.next;
        mid.next=null;
        while (secondHead!=null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = secondHead.next;
            first.next=secondHead;
            secondHead.next=tmp1;
            first=tmp1;
            secondHead=tmp2;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode temp = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode l1 = head;
        while (fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }
    private ListNode reverse(ListNode head){
        ListNode pre =null;
        while (head!=null){
            ListNode tmp = head.next;
            head.next=pre;
            pre=head;
            head=tmp;
        }
        return pre;
    }
    private void merge (ListNode part1, ListNode part2){
        while (part1!=part2){
            ListNode n1 = part1.next, n2 = part2.next;
            part1.next=part2;
            if (n1==null) break;
            part2.next = n1;
            part1=n1;
            part2=n2;
        }
    }
}
