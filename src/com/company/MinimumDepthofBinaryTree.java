package com.company;
// Tree, BFS
import java.util.LinkedList;

public class MinimumDepthofBinaryTree {
    /**
     * Given a binary tree, find its minimum depth.

     The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

     Note: A leaf is a node with no children.

     Example:

     Given binary tree [3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     return its minimum depth = 2.
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        int level=1;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            int size = list.size();
            for (int i=0; i<size; ++i){
                TreeNode cur = list.poll();
                if (cur.left==null && cur.right==null) return level;
                if (cur.left!=null) {
                    list.add(cur.left);
                }
                if (cur.right!=null){
                    list.add(cur.right);
                }
            }
            level++;
        }
        return level;
    }

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val=val;
        }
    }
}
