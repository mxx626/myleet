package com.company;
// Tree, DFS
public class BinaryTreeLongestConsecutiveSequence {
    /**
     * Given a binary tree, find the length of the longest consecutive sequence path.

     The path refers to any sequence of nodes from some starting node to any node in
     the tree along the parent-child connections. The longest consecutive path need
     to be from parent to child (cannot be the reverse).

     For example,
     1
     \
     3
     / \
     2   4
     \
     5
     Longest consecutive sequence path is 3-4-5, so return 3.
     2
     \
     3
     /
     2
     /
     1
     Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
     */
    private int ret = 0;
    public int longestConsecutive(TreeNode root) {
        if (root==null) return 0;
        helper(root, root.val, 0);
        return ret;
    }
    private void helper(TreeNode root, int target, int len)
    {
        if (root==null) return;
        if (root.val==target) len++;
        else len=1;
        ret = Math.max(ret, len);
        helper(root.left, root.val+1, len);
        helper(root.right, root.val+1,len);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
