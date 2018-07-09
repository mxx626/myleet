package com.company;
// Tree, DFS

import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree {
    /**
     * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove
     * all leaves, repeat until the tree is empty.

     Example:
     Given binary tree
     1
     / \
     2   3
     / \
     4   5
     Returns [4, 5, 3], [2], [1].

     Explanation:
     1. Removing the leaves [4, 5, 3] would result in this tree:

     1
     /
     2
     2. Now removing the leaf [2] would result in this tree:

     1
     3. Now removing the leaf [1] would result in the empty tree:

     []
     Returns [4, 5, 3], [2], [1].
     */
    private List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return ret;
    }
    private int helper(TreeNode root)
    {
        if (root==null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int level1 = Math.max(l, r);
        if (ret.size()<=level1) ret.add(new ArrayList<>());
        ret.get(level1).add(root.val);
        level1++;
        return level1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
