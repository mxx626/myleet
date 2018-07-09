package com.company;
/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 0->1->4->3->2->5->2 and x = 3,
 *       p
 * return 1->2->2->4->3->5.
 * **/
public class PartitionList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur!=null && cur.val<x){
            pre = cur;
            cur = cur.next;
        }
        if (cur==null) return head;
        while (cur!=null && cur.next!=null){
            if (cur.next.val>=x){
                cur=cur.next;
            }
            else {
                ListNode node = cur.next;
                cur.next = node.next;
                node.next=pre.next;
                pre.next=node;
                pre=pre.next;
            }
        }
        return dummy.next;
    }
}
