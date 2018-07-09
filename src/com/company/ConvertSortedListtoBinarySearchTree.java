package com.company;
// TAG: LinkedList, Recursion
public class ConvertSortedListtoBinarySearchTree {
    /**
     * Given a singly linked list where elements are sorted in ascending order,
     * convert it to a height balanced BST.

     For this problem, a height-balanced binary tree is defined as a binary tree
     in which the depth of the two subtrees of every node never differ by more than 1.

     Example:

     Given the sorted linked list: [-10,-3,0,5,9],

     One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

     0
     / \
     -3   9
     /   /
     -10  5
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return new TreeNode(head.val);
        TreeNode root = helper(head);
        return root;
    }
    private TreeNode helper(ListNode head){
        if (head==null) return null;
        if (head.next==null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre  = head;
        while (fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secH = slow.next;
        TreeNode root = new TreeNode (slow.val);
        pre.next=null;
        root.left = helper(head);
        root.right = helper(secH);
        return root;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
