package com.company;

import java.util.List;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note
 * here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example:
 * Given 1->2->3->4->5->6->7->8->NULL,
 *       1->2->3->4->5->6->7->8->9->NULL
 * return1->3->5->7->2->4->6->8->NULL.
 * 1->3->5->7->9
 * 2->4->6->8
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 **/
public class OddEvenLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) return head;
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        ListNode tmp = head.next;
        while (oddPtr.next!=null && oddPtr.next.next!=null) {
            oddPtr.next = oddPtr.next.next;
            oddPtr = oddPtr.next;
            evenPtr.next = evenPtr.next.next;
            evenPtr = evenPtr.next;
        }
        oddPtr.next=tmp;
        return head;
    }
}
