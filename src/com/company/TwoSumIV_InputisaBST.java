package com.company;
// Tree
import java.util.HashSet;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST

 Given a Binary Search Tree and a target number, return true if
 there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:
 Input:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 9

 Output: True
 Example 2:
 Input:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 28

 Output: False
 */
public class TwoSumIV_InputisaBST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
    private boolean helper(TreeNode root, int k, Set<Integer> set){
        if (root==null) return false;
        if (set.contains(k-root.val)) return true;
        set.add(root.val);
        return helper(root.left, k, set) || helper(root.right, k, set);
    }


    public class TreeNode {
        int val;
        TreeNode left, right, next;
        TreeNode(int x) { val = x; }
    }
}
