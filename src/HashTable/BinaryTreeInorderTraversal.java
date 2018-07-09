package HashTable;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    private List<Integer> res = new LinkedList();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }
    private void helper(TreeNode node){
        if (node==null) return;
        helper(node.left);
        res.add(node.val);
        helper(node.right);
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root==null) return res;
        Stack<TreeNode> s = new Stack<>();
        while (root!=null){
            s.push(root);
            root=root.left;
        }
        while (!s.isEmpty()){
            TreeNode cur = s.pop();
            res.add(cur.val);
            if (cur.right!=null){
                TreeNode tmp = cur.right;
                while (tmp!=null){
                    s.push(tmp);
                    tmp=tmp.left;
                }
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root==null) return res;
        Stack<TreeNode> s = new Stack<>();
        while (root!=null || !s.isEmpty()){
            if (root!=null){
                s.push(root);
                root=root.left;
            }
            else {
                root = s.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
