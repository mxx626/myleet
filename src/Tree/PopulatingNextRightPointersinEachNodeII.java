package Tree;
// TAG: Tree, DFS, LevelOrder
public class PopulatingNextRightPointersinEachNodeII {
    /**
     * Given a binary tree

     struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
     }
     Populate each next pointer to point to its next right node. If there is no next right
     node, the next pointer should be set to NULL.

     Initially, all next pointers are set to NULL.

     Note:

     You may only use constant extra space.
     Recursive approach is fine, implicit stack space does not count as extra space for this problem.
     Example:

     Given the following binary tree,

     1
     /  \
     2    3
     / \    \
     4   5    7
     After calling your function, the tree should look like:

     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \    \
     4-> 5 -> 7 -> NULL

     * @param root
     */
    public void connect2(TreeLinkNode root) {
        while (root!=null)
        {
            TreeLinkNode rowHead = new TreeLinkNode(0);
            TreeLinkNode head = rowHead;
            while(root!=null)
            {
                if (root.left!=null)
                {
                    head.next=root.left;
                    head=head.next;
                }
                if (root.right!=null)
                {
                    head.next=root.right;
                    head=head.next;
                }
                root=root.next;
            }
            root = rowHead.next;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root==null) return;
        helper(root);
    }
    private void helper(TreeLinkNode root){
        if (root==null) return;
        if (root.left==null && root.right==null) return;
        if (root.right==null) {
            root.left.next = getNext(root);
        }
        if (root.right!=null){
            if (root.left!=null) root.left.next=root.right;
            root.right.next = getNext(root);
        }
        helper(root.right);
        helper(root.left);

    }
    private TreeLinkNode getNext(TreeLinkNode root){
        if (root==null) return null;
        TreeLinkNode cur = root.next;
        while (cur!=null){
            if (cur.left!=null){
                return cur.left;
            }
            else if (cur.right!=null){
                return cur.right;
            }
            cur=cur.next;
        }
        return null;
    }
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
