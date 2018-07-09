package com.company;
// TAG: Arrays, Tree, DFS
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.

     Note:
     You may assume that duplicates do not exist in the tree.

     For example, given

     inorder = [9,3,15,20,7]
     postorder = [9,15,7,20,3]
     Return the following binary tree:

     3
     / \
     9  20
     /  \
     15   7
     *
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; ++i){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length-1, postorder.length-1, map);
    }

    private TreeNode helper(int[] in, int[] post, int inS, int inE, int postS, Map<Integer, Integer> map){
        if (inS>inE || postS<0) return null;
        TreeNode root = new TreeNode(post[postS]);
        int idx = map.get(root.val);
        int rightLen = inE-idx;
        root.left = helper(in, post, inS, idx-1, postS-rightLen-1, map);
        root.right = helper(in, post, idx+1, inE, postS-1, map);
        return root;
    }
}
