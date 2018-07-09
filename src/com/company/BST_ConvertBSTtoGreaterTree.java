package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class BST_ConvertBSTtoGreaterTree {
    /**
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the
     * original BST is changed to the original key plus sum of all keys greater than the original
     * key in BST.
     *
     * Example:
     * Input: The root of a Binary Search Tree like this:
     *              5
     *            /   \
     *          2     13
     * Output: The root of a Greater Tree like this:
     *              18
     *            /   \
     *          20     13
     * **/
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode convertBST(TreeNode root) {
        if (root==null) return root;
        tranverse(root);
        return root;
    }

    private int tranverse (TreeNode root){
        if (root==null) return 0;
        int right = tranverse(root.right);
        root.val += right;
        TreeNode node = root.left;
        if (node!=null){
            while (node.right!=null){
                node=node.right;
            }
            node.val+=root.val;
        }
        int left = tranverse(root.left);
        return left==0 ? root.val : left;
    }
}
