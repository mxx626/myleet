package com.company;
// Tree
/**
 * 270. Closest Binary Search Tree Value

 Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:

 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.
 Example:

 Input: root = [4,2,5,1,3], target = 3.714286

 4
 / \
 2   5
 / \
 1   3

 Output: 4

 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, root.val);
    }
    private int helper(TreeNode root, double target, int closest){
        if (root==null || target-closest==0) {
            return closest;
        }
        if (Math.abs(root.val-target)<Math.abs(closest-target)){
            closest = root.val;
        }
        if (closest-target==0) return closest;
        if (root.val>target){
            closest = helper(root.left, target, closest);
        }
        else if (root.val<target){
            closest = helper(root.right, target, closest);
        }
        return closest;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
