package Tree;
// TAG: Tree, DFS
import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
    /**
     *Given a binary tree, flatten it to a linked list in-place.

     For example, given the following tree:

     1
     / \
     2   5
     / \   \
     3   4   6
     The flattened tree should look like:

     1
     \
     2
     \
     3
     \
     4
     \
     5
     \
     6
     * @param root
     */

    public void flatten2(TreeNode root) {
        if (root==null) return;
        TreeNode cur = root;
        while (cur!=null){
            if (cur.left!=null){
                TreeNode tmp = cur.left;
                while (tmp.right!=null) tmp = tmp.right;
                tmp.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
    }

    public void flatten3(TreeNode root) {
        if (root==null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            TreeNode cur = s.pop();
            if (cur.left!=null){
                TreeNode tmp = cur.left;
                while (tmp.right!=null) tmp = tmp.right;
                tmp.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            if (cur.right!=null) s.push(cur.right);
        }
    }

    public void flatten(TreeNode root) {
        if (root==null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right=root.left;
        root.left=null;
        while (root.right!=null) root=root.right;
        root.right=tmp;
        return;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



}
