package Tree;
// Tree, DFS
public class BalancedBinaryTree {
    private boolean flag = true;

    /**
     * Given a binary tree, determine if it is height-balanced.

     For this problem, a height-balanced binary tree is defined as:

     a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

     Example 1:

     Given the following tree [3,9,20,null,null,15,7]:

     3
     / \
     9  20
     /  \
     15   7
     Return true.

     Example 2:

     Given the following tree [1,2,2,3,3,null,null,4,4]:

     1
     / \
     2   2
     / \
     3   3
     / \
     4   4
     Return false.
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.abs(left-right)<2 && flag;
    }
    private int helper(TreeNode root){
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 1;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left-right)>1) flag = false;
        return Math.max(left, right)+1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
