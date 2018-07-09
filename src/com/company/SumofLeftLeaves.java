package com.company;

import java.util.Stack;

// Tree, DFS, preOrder
public class SumofLeftLeaves {

    private int res = 0;

    /**
     * Find the sum of all left leaves in a given binary tree.

     Example:

     3
     / \
     9  20
     /  \
     15   7

     There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return 0;
        helper(root.left, true);
        helper(root.right, false);
        return res;
    }
    private void helper(TreeNode root, boolean left){
        if (root==null) return;
        if (root.left==null && root.right==null && left){
            res+=root.val;
            return;
        }
        helper(root.left, true);
        helper(root.right, false);
    }



    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    ans += node.left.val;
                }
                stack.push(node.left);
            }
        }
        return ans;
    }


    public class TreeNode {
        int val;
        TreeNode left, right, next;
        TreeNode(int x) { val = x; }
    }
}
