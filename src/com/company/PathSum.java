package com.company;
// Tree, DFS
public class PathSum {
    /**
     * iven a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

     Note: A leaf is a node with no children.

     Example:

     Given the below binary tree and sum = 22,

     5
     / \
     4   8
     /   / \
     11  13  4
     /  \      \
     7    2      1
     return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }
    private boolean helper(TreeNode root, int sum){
        if (root==null) return false;
        if (root.left==null && root.right==null && sum==root.val) return true;
        boolean left = helper(root.left, sum-root.val);
        boolean right = helper(root.right, sum-root.val);
        return left||right;
    }

    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
