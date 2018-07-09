package Tree;
// Tree
import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if (left==null && right==null) return  true;
        else if (left==null||right==null) return false;
        return left.val==right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root==null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        Stack<TreeNode> sL = new Stack<>();
        Stack<TreeNode> sR = new Stack<>();
        while ((!sL.isEmpty() || left!=null) && (!sR.isEmpty() || right!=null)){
            if (left!=null && right!=null){
                if (left.val!=right.val) return false;
                sL.push(left);
                sR.push(right);
                left = left.left;
                right = right.right;
            }
            else if (left==null && right==null){
                left = sL.pop();
                right = sR.pop();
                left = left.right;
                right = right.left;
            }
            else {
                return false;
            }
        }
        if ((left==null && right!=null) || (left!=null && right==null)) return false;
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int val){
            this.val = val;
        }
    }
}
