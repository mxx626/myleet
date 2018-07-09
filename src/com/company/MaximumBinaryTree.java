package com.company;

import java.util.LinkedList;

public class MaximumBinaryTree {
    /**
     * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

     The root is the maximum number in the array.
     The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
     The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
     Construct the maximum tree by the given array and output the root node of this tree.

     Example 1:
     Input: [3,2,1,6,0,5]
     Output: return the tree root node representing the following tree:

     6
     /   \
     3     5
     \    /
     2  0
     \
     1
     Note:
     The size of the given array will be in the range [1,1000].

     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        LinkedList<TreeNode> s = new LinkedList<>();
        for (int num : nums){
            TreeNode cur = new TreeNode(num);
            while (!s.isEmpty() && s.peek().val<num){
                cur.left = s.pop();
            }
            if (!s.isEmpty()){
                s.peek().right = cur;
            }
            s.push(cur);
        }
        return s.peekLast();
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length);
        return root;
    }
    private TreeNode helper(int[] nums, int start, int end){
        if (start>=end) return null;
        int max = Integer.MIN_VALUE, idx=0;
        //  System.out.println(max);
        for (int i=start; i<end; ++i){
            if (nums[i]>max){
                max=nums[i];
                idx=i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, idx);
        root.right = helper(nums, idx+1, end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
