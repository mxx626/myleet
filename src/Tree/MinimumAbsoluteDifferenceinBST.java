package Tree;
// Tree
public class MinimumAbsoluteDifferenceinBST {
    int res = Integer.MAX_VALUE;
    Integer pre = null;

    /**
     * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

     Example:

     Input:

     1
     \
     3
     /
     2

     Output:
     1

     Explanation:
     The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root==null) return 0;
        helper(root);
        return res;
    }
    private void helper(TreeNode root){
        if (root==null) return;
        helper(root.left);
        if (pre!=null){
            res = Math.min(res, root.val-pre);
        }
        pre = root.val;
        helper(root.right);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode (int val){
            this.val = val;
        }
    }
}
