package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree {
    /**
     * Print a binary tree in an m*n 2D string array following these rules:
     *
     * The row number m should be equal to the height of the given binary tree.
     The column number n should always be an odd number.
     The root node's value (in string format) should be put in the exactly middle of the first
     row it can be put. The column and the row where the root node belongs will separate the
     rest space into two parts (left-bottom part and right-bottom part). You should print the
     left subtree in the left-bottom part and print the right subtree in the right-bottom part.
     The left-bottom part and the right-bottom part should have the same size. Even if one subtree
     is none while the other is not, you don't need to print anything for the none subtree but still
     need to leave the space as large as that for the other subtree. However, if two subtrees are none,
     then you don't need to leave space for both of them.

     Each unused space should contain an empty string "".
     Print the subtrees following the same rules.

     Example 1:
     Input:
                1
              /
            2
     Output:
     [["", "1", ""],
     ["2", "", ""]]
     * **/
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private List<List<String>> res;
    private int depth=0;
    public List<List<String>> printTree(TreeNode root) {
        res=new ArrayList<>();
        if (root==null) return res;
        TreeNode node = root;
        getDepth(node, 1);
        String[][] arr = new String[depth][1<<depth-1];
        for (String[] a : arr) Arrays.fill( a, "");
        addNode(root, 0, arr[0].length, 0, arr);
        for (String[] a : arr){
            res.add(Arrays.asList(a));
        }
        return res;
    }
    private void addNode (TreeNode root, int start, int end, int level, String[][] arr){
        if (root==null) return;
        arr[level][(start+end)/2]=""+root.val;
        addNode(root.left, start, (end+start)/2, level+1, arr);
        addNode(root.right, (end+start+1)/2, end, level+1, arr);
    }
    private void getDepth (TreeNode root, int level){
        if (root==null) return;
        depth=Math.max(depth, level);
        getDepth(root.left, level+1);
        getDepth(root.right, level+1);
    }
}
