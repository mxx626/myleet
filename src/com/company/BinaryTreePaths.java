package com.company;
// DFS
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    private final static String ARROW = "->";

    /**
     * Given a binary tree, return all root-to-leaf paths.

     Note: A leaf is a node with no children.

     Example:

     Input:

     1
     /   \
     2     3
     \
     5

     Output: ["1->2->5", "1->3"]

     Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, new StringBuilder(), res);
        return res;
    }
    private void helper(TreeNode root, StringBuilder sb, List<String> res){
        if (root==null) return;
        if  (root.left==null && root.right==null){
            int len1 = sb.length();
            sb.append(root.val);
            res.add(sb.toString());
            sb.delete(len1, sb.length());
            return;
        }
        int len = sb.length();
        sb.append(root.val).append(ARROW);
        helper(root.left, sb, res);
        helper(root.right, sb, res);
        sb.delete(len, sb.length());
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
