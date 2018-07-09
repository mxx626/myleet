package com.company;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How
 * would you optimize the kthSmallest routine?
 * **/
public class KthSmallestElementInBST {

    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    // Iterative solution.
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            count++;
            if (count==k) return node.val;
            if (node.right!=null){
                node=node.right;
                while (node!=null){
                    stack.push(node);
                    node=node.left;
                }
            }
        }
        return 0;
    }
    private static int count;
    private static int res;
    public int kthSmallest1(TreeNode root, int k) {
        count=k;
        res=0;
        traverse(root);
        return res;
    }

    public void traverse (TreeNode root){
        if (root==null) return;
        traverse(root.left);
        count--;
        if (count==0) res=root.val;
        traverse(root.right);
    }
}
