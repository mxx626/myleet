package com.company;
// TAG: Tree, Binary Search
import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {
    /**
     * Given a complete binary tree, count the number of nodes.

     Definition of a complete binary tree from Wikipedia:
     In a complete binary tree every level, except possibly the last, is completely
     filled, and all nodes in the last level are as far left as possible. It can have
     between 1 and 2h nodes inclusive at the last level h.


     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count=1;
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (cur.val!=-1){
                cur.val=-1;
                if (cur.left!=null){
                    count++;
                    q.offer(cur.left);
                }
                if (cur.right!=null){
                    count++;
                    q.offer(cur.right);
                }
            }
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int right=0, left=0;
        left = getHeight(root.left);
        right = getHeight(root.right);
        if (left==right) return (1<<left) + countNodes(root.right);
        else return (1<<right)+countNodes(root.left);

    }
    private int getHeight(TreeNode root){
        int h=0;
        while (root!=null){
            root=root.left;
            ++h;
        }
        return h;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
