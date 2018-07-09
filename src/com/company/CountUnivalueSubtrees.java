package com.company;
// TAG: Tree, DFS
public class CountUnivalueSubtrees {
    /**
     * Given a binary tree, count the number of uni-value subtrees.

     A Uni-value subtree means all nodes of the subtree have the same value.

     For example:
     Given binary tree,
     5
     / \
     1   5
     / \   \
     5   5   5
     return 4.
     */
    private int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        count(root);
        return res;
    }
    private boolean count (TreeNode root){
        if (root==null) return true;
        boolean left = count(root.left);
        boolean right = count(root.right);
        if (root.left!=null && root.val!=root.left.val) return false;
        if (root.right!=null && root.val!=root.right.val) return false;
        if (left&&right)
        {
            res++;
            return true;
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
