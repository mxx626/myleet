package com.company;
// Tree, DFS
public class SameTree {
    /**
     * Given two binary trees, write a function to check if they are the same or not.

     Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

     Example 1:

     Input:     1         1
     / \       / \
     2   3     2   3

     [1,2,3],   [1,2,3]

     Output: true
     Example 2:

     Input:     1         1
     /           \
     2             2

     [1,2],     [1,null,2]

     Output: false
     Example 3:

     Input:     1         1
     / \       / \
     2   1     1   2

     [1,2,1],   [1,1,2]

     Output: false
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q==null && p==null) return true;
        if (q==null || p==null || p.val!=q.val) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left&&right;
    }

    public class TreeNode {
        int val;
        TreeNode left, right, next;
        TreeNode(int x) { val = x; }
    }
}
