package Tree;
// Tree
import java.util.Stack;

/**
 * 538. Convert BST to Greater Tree

 Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key
 of the original BST is changed to the original key plus sum of all keys greater than
 the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
 5
 /   \
 2     13

 Output: The root of a Greater Tree like this:
 18
 /   \
 20     13
 */
public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root==null) return null;
        Stack<TreeNode> st = new Stack<>();
        int sum=0;
        TreeNode cur = root;
        while (!st.isEmpty() || cur!=null){
            if (cur!=null){
                st.push(cur);
                cur=cur.right;
            }
            else{
                cur = st.pop();
                cur.val+=sum;
                sum=cur.val;
                cur=cur.left;
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
