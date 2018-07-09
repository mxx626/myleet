package Tree;
// TAG: Tree, DFS
public class PopulatingNextRightPointersinEachNode {
    /**
     * Given a binary tree

     struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
     }
     Populate each next pointer to point to its next right node. If there is no next
     right node, the next pointer should be set to NULL.

     Initially, all next pointers are set to NULL.

     Note:

     You may only use constant extra space.
     Recursive approach is fine, implicit stack space does not count as extra space for this problem.
     You may assume that it is a perfect binary tree (ie, all leaves are at the same
     level, and every parent has two children).
     Example:

     Given the following perfect binary tree,

     1
     /  \
     2    3
     / \  / \
     4  5  6  7
     After calling your function, the tree should look like:

     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \  / \
     4->5->6->7 -> NULL
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        root.next=null;
        helper(root);
    }
    private TreeLinkNode helper(TreeLinkNode root){
        if (root==null) return null;
        if (root.left==null && root.right==null) return null;
        root.left.next = root.right;
        if (root.next!=null)
            root.right.next = root.next.left;
        else root.right.next=null;
        helper(root.left);
        helper(root.right);
        return root;
    }

    public class TreeLinkNode {
       int val;
       TreeLinkNode left, right, next;
       TreeLinkNode(int x) { val = x; }
    }

}
