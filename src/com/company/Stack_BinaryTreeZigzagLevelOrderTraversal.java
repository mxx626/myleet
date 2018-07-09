package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right
 * to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * **/
public class Stack_BinaryTreeZigzagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        traverse(res, stack, 0);
        return res;
    }

    public List<List<Integer>> traverse (List<List<Integer>> res, Stack<TreeNode> stack, int level){
        if (stack.size()==0) return res;
        if (res.size()==level) {
            res.add(new ArrayList<>());
        }
        Stack<TreeNode> tmp = new Stack<>();
        if (level%2==1){
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                res.get(level).add(node.val);
                if (node.right!=null) tmp.add(node.right);
                if (node.left !=null) tmp.add(node.left);
            }
            traverse(res, tmp, level+1);
        }
        else if (level%2==0){
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                res.get(level).add(node.val);
                if (node.left!=null) tmp.add(node.left);
                if (node.right!=null) tmp.add(node.right);
            }
            traverse(res,tmp, level+1);
        }
        return res;
    }

    // use the add function, we can add the element from the left
    // to right when we set the idx to 0, the element will shift from left->right
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        traverse2(res, root, 0);
        return res;

    }
    public List<List<Integer>> traverse2 (List<List<Integer>> res, TreeNode root, int level){
        if (root==null) return res;
        if (res.size()<=level){
            res.add(level, new ArrayList<>());
        }
        if (level%2==0) res.get(level).add(root.val);
        else {
            res.get(level).add(0, root.val);
        }
        traverse2(res, root.left, level+1);
        traverse2(res, root.right, level+1);
        return res;
    }
}
