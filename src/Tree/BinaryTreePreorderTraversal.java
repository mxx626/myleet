package Tree;
// TAG: Tree
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    /**
     *Given a binary tree, return the preorder traversal of its nodes' values.

     Example:

     Input: [1,null,2,3]
     1
     \
     2
     /
     3

     Output: [1,2,3]
     Follow up: Recursive solution is trivial, could you do it iteratively?
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) return res;
        helper(root);
        return res;
    }
    private void helper(TreeNode root){
        if (root==null) return;
        res.add(root.val);
        helper(root.left);
        helper(root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            if (root!=null){
                res.add(root.val);
                stack.push(root);
                root=root.left;
            }
            else {
                root = stack.pop();
                root = root.right;
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
