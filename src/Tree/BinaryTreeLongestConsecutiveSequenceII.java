package Tree;
// Tree
/**
 * 549. Binary Tree Longest Consecutive Sequence II

 Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

 Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and
 [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand,
 the path can be in the child-Parent-child order, where not necessarily be parent-child order.

 Example 1:
 Input:
 1
 / \
 2   3
 Output: 2
 Explanation: The longest consecutive path is [1, 2] or [2, 1].
 Example 2:
 Input:
 2
 / \
 1   3
 Output: 3
 Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    // arr[0] decrease, arr[1] increase
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }
    private int[] helper(TreeNode root){
        if (root==null) return new int[2];
        int de=1, in=1;
        if (root.left!=null){
            int[] left = helper(root.left);
            if (root.left.val+1==root.val) de = left[0]+1;
            else if (root.left.val-1==root.val) in = left[1]+1;
        }
        if (root.right!=null){
            int[] right = helper(root.right);
            if (root.right.val+1==root.val) {
                de = Math.max(de, right[0]+1);
            }
            else if (root.right.val-1==root.val){
                in = Math.max(in, right[1]+1);
            }
        }
        res = Math.max(res, de+in-1);
        return new int[]{de, in};
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
