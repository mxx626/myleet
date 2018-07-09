package com.company;
// Tree
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    private List<Integer> res = new ArrayList<>();

    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
        if (root==null) return;
        helper(root.left);
        helper(root.right);
        res.add(root.val);

    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root!=null || !s.isEmpty()){
            if(root!=null){
                s.push(root);
                res.add(0, root.val);
                root=root.right;
            }
            else {
                root = s.pop();
                root = root.left;
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
