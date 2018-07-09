package DFSorBFS;
// Tree, DFS
public class ConvertSortedArraytoBinarySearchTree {
    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

     For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

     Example:

     Given the sorted array: [-10,-3,0,5,9],

     One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

     0
     / \
     -3   9
     /   /
     -10  5
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length==0) return null;
        TreeNode root = helper(nums, 0, nums.length-1);
        return root;
    }
    private TreeNode helper(int[] nums, int start, int end){
        if (start>end) return null;
        if (start==end) return new TreeNode(nums[start]);
        int mid = start+(end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid-1);
        node.right = helper(nums, mid+1, end);
        return node;
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
