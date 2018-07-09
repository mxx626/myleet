package BinarySearch;
// TAG: Binary Search, Tree
import java.util.Stack;

public class KthSmallestElementinaBST {
    /**
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

     Note:
     You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

     Follow up:
     What if the BST is modified (insert/delete operations) often and you need to find the kth smallest
     frequently? How would you optimize the kthSmallest routine?

     Credits:
     Special thanks to @ts for adding this problem and creating all test cases.


     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root==null) return 0;
        Stack<TreeNode> s = new Stack<>();
        int res=0;
        while (root!=null){
            s.push(root);
            root=root.left;
        }
        while (!s.isEmpty()){
            TreeNode cur = s.pop();
            k--;
            if (k==0) {
                res=cur.val;
                break;
            }
            while (cur.right!=null){
                s.push(cur.right);
                cur.right = cur.right.left;
            }
        }
        return res;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
///////////////////////////////////////////////////////////////////////
    private int res=0;
    private int count=0;
    public int kthSmallest2(TreeNode root, int k) {
        if (root==null) return 0;
        add(k, root);
        return res;
    }
    private void add(int k, TreeNode root){
        if (root==null) return;
        add(k, root.left);
        count++;
        if (count==k) {
            res=root.val;
            return;
        }
        add(k, root.right);
    }
}
