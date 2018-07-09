package com.company;

import java.util.List;
//TAG: Tree, DP

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 * **/
public class UniqueBinarySearchTreesII {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n+1];
        res[0] = new ArrayList<>();
        if (n==0) return res[0];
        res[0].add(null);
        for (int i=1; i<=n; ++i){
            res[i]=new ArrayList<>();
            for (int j=0; j<i; ++j){
                for (TreeNode left : res[j]){
                    for (TreeNode right : res[i-j-1]){
                        TreeNode root = new TreeNode(j+1);
                        root.left = left;
                        root.right = constructTree(right, j+1);
                        res[i].add(root);
                    }
                }
            }
        }
        return res[n];
    }

    public TreeNode constructTree (TreeNode root, int offset){
        if (root==null) return root;
        TreeNode node = new TreeNode(root.val+offset);
        node.left = constructTree(root.left, offset);
        node.right = constructTree(root.right, offset);
        return root;
    }

    public List<TreeNode> generateTrees2(int n) {
        if (n==0) return new ArrayList<>();
        return helper(1, n);
    }

    public List<TreeNode> helper (int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
        }
        for (int idx = start; idx <= end; ++idx){
            List<TreeNode> leftList = helper(start, idx-1);
            List<TreeNode> rightList = helper(idx+1, end);
            for (TreeNode left : leftList){
                for (TreeNode right : rightList){
                    TreeNode root = new TreeNode(idx);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
