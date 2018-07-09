package Tree;
// TAG: Stack, Tree, DFS
import java.util.Stack;

public class InorderSuccessorinBST {
    /**
     * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

     Note: If the given node has no in-order successor in the tree, return null.
     * @param root
     * @param p
     * @return
     */
    private TreeNode res = null;
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        while (root!=null)
        {
            if (root.val>p.val)
            {
                res = root;
                root=root.left;
            }
            else root=root.right;
        }
        return res;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (root!=null || !s.isEmpty())
        {
            if (root!=null)
            {
                s.push(root);
                root=root.left;
            }
            else
            {
                root = s.pop();
                if (pre!=null) return root;
                if (root==p) pre = root;
                root=root.right;
            }
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
