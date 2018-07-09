package com.company;
// TAG: Stack, Tree, DFS
import java.util.Stack;

public class ValidateBinarySearchTree {
    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.
     Example 1:

     Input:
     2
     / \
     1   3
     Output: true
     Example 2:

     5
     / \
     1   4
     / \
     3   6
     Output: false
     Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
     is 5 but its right child's value is 4.
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root==null) return true;
        TreeNode cur = root;
        TreeNode pre = null;
        Stack<TreeNode> s = new Stack<>();
        while (root!=null || !s.isEmpty())
        {
            if (root!=null)
            {
                s.push(root);
                root=root.left;
            }
            else
            {
                root = s.pop();
                if (pre!=null && root.val <= pre.val ) return false;
                pre = root;
                root=root.right;
            }
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        return helper(root.left, null, root.val) && helper(root.right, root.val, null);
    }
    private boolean helper(TreeNode root, Integer low, Integer high){
        if (root==null) return true;
        if (low!=null && root.val<=low) return false;
        if (high!=null&& root.val>=high) return false;
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
