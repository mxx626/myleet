package com.company;

import java.util.List;
import java.util.Stack;

public class AddTwoNumbersII {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The most significant digit
     * comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Follow up:
     * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
     * Example:
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     * **/
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        int sum=0;
        while (l1!=null){
            s1.push(l1);
            l1=l1.next;
        }
        while (l2!=null){
            s2.push(l2);
            l2=l2.next;
        }
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()){
            if (!s1.isEmpty()) sum+=s1.pop().val;
            if (!s2.isEmpty()) sum+=s2.pop().val;
            list.val=sum%10;
            sum/=10;
            ListNode head = new ListNode(sum);
            head.next=list;
            list=head;
        }
        return list.val==0 ? list.next : list;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode head = new ListNode(1);
        head.next = size1>size2 ? helper (l1, l2, size1-size2) : helper (l2, l1, size2-size1);
        if (head.next.val>9){
            head.next.val%=10;
            return head;
        }
        return head.next;
    }
    private ListNode helper (ListNode l1, ListNode l2, int offset){
        if (l1==null) return null;
        ListNode res = new ListNode(0);
        res.val = offset==0 ? l1.val+l2.val : l1.val;
        ListNode post = offset==0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset-1);
        if (post!=null && post.val>9){
            res.val+=1;
            post.val%=10;
        }
        res.next=post;
        return res;
    }
    private int getLength (ListNode head){
        int len=0;
        while (head!=null){
            head=head.next;
            len++;
        }
        return len;
    }
}
