package Tree;
// Tree
public class LongestUnivaluePath {
    int ret = 0;

    /**
     * Given a binary tree, find the length of the longest path where each node in
     * the path has the same value. This path may or may not pass through the root.

     Note: The length of path between two nodes is represented by the number of edges between them.

     Example 1:

     Input:

     5
     / \
     4   5
     / \   \
     1   1   5
     Output:

     2
     Example 2:

     Input:

     1
     / \
     4   5
     / \   \
     4   4   5
     Output:

     2
     Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root==null) return 0;
        helper(root);
        return ret;
    }
    private int helper(TreeNode root){
        if (root==null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int left = root.left==null ? 0 : (root.left.val==root.val ? 1+l : 0);
        int right = root.right==null ? 0 : (root.right.val==root.val ? 1+r : 0);
        ret = Math.max(ret, left+right);
        return Math.max(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
