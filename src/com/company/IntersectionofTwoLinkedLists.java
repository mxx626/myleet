package com.company;
// ListNode

/**
 * 160. Intersection of Two Linked Lists

 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;
        int len1=0, len2=0;
        while (headA!=null){
            len1++;
            headA=headA.next;
        }
        while(headB!=null){
            len2++;
            headB=headB.next;
        }
        int diff = Math.abs(len1-len2);
        if (len1>len2){
            while (diff!=0){
                n1=n1.next;
                diff--;
            }
        }
        else {
            while(diff!=0){
                n2=n2.next;
                diff--;
            }
        }
        while(n1!=n2){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
