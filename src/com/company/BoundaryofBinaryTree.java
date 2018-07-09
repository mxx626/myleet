package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryofBinaryTree {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree2(TreeNode root) {
        if (root==null) return res;

        res.add(root.val);

        getLeft(root.left);
        getBottom(root.left);
        getBottom(root.right);
        getRight(root.right);

        return res;
    }
    private void getLeft(TreeNode left){
        if (left==null) return;
        if (left.left==null && left.right==null) return;
        res.add(left.val);
        if (left.left!=null) {
            getLeft(left.left);
        }
        else {
            getLeft(left.right);
        }
    }
    private void getRight(TreeNode right){
        if (right==null) return;
        if (right.left==null && right.right==null) return;
        if (right.right!=null) {
            getRight(right.right);
        }
        else {
            getRight(right.left);
        }
        res.add(right.val);
    }
    private void getBottom(TreeNode node){
        if (node==null) return;
        if (node.left==null && node.right==null)
            res.add(node.val);
        getBottom(node.left);
        getBottom(node.right);

    }



    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> rstack = new Stack<>();
        TreeNode p = root;
        TreeNode cur = root.right;
        boolean left=true, right=false;
        while (root!=null || !stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                if(root.left==null && root.right==null) res.add(root.val);
                else if(left && !right) res.add(root.val);
                root=root.left;
            }
            else {
                root = stack.pop();
                if (p==root) right=true;
                if (root.left==null && root.right==null) left=false;
                root=root.right;
            }
        }
        int size=res.size();
        while (cur!=null){
            if (cur.left==null && cur.right==null) break;
            res.add(size, cur.val);
            if (cur.right!=null){
                cur=cur.right;
            }
            else if(cur.left!=null){
                cur=cur.left;
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
