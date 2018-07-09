package Tree;
// Tree, Recursion
public class DeleteNodeinaBST {
    /**
     *Given a root node reference of a BST and a key, delete the node with the given key in the
     * BST. Return the root node reference (possibly updated) of the BST.

     Basically, the deletion can be divided into two stages:

     Search for a node to remove.
     If the node is found, delete the node.
     Note: Time complexity should be O(height of tree).

     Example:

     root = [5,3,6,2,4,null,7]
     key = 3

     5
     / \
     3   6
     / \   \
     2   4   7

     Given key to delete is 3. So we find the node with value 3 and delete it.

     One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

     5
     / \
     4   6
     /     \
     2       7

     Another valid answer is [5,2,6,null,4,null,7].

     5
     / \
     2   6
     \   \
     4   7

     * @param root
     * @param key
     * @return
     */

    // Solution I
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return null;
        if (root.val>key)
        {
            root.left = deleteNode(root.left, key);
        }
        else if (root.val<key)
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            if (root.left==null) return root.right;
            else if (root.right==null) return root.left;

            TreeNode newRoot = findMin(root.right);
            root.val = newRoot.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    private TreeNode findMin(TreeNode node)
    {
        while (node.left!=null) node = node.left;
        return node;
    }

    //Solution II
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root==null) return null;
        TreeNode pre = new TreeNode(0);
        TreeNode cur = root;
        TreeNode test = root;
        while (cur!=null)
        {
            if (cur.val>key)
            {
                pre=cur;
                cur=cur.left;
            }

            else if (cur.val<key)
            {
                pre=cur;
                cur=cur.right;
            }
            else break;
        }
        if (cur==null) return root;
        if (pre.left==cur)
        {
            pre.left=null;
            if (cur.right!=null)
            {
                TreeNode node = cur.left;
                pre.left=cur.right;
                TreeNode tmp = cur.right;
                while (tmp.left!=null)
                {
                    tmp=tmp.left;
                }
                tmp.left = node;
            }
            else {
                pre.left = cur.left;
            }
        }
        else
        {
            pre.right=null;
            if (cur.right!=null)
            {
                TreeNode node = cur.left;
                pre.right=cur.right;
                TreeNode tmp = cur.right;
                while (tmp.left!=null)
                {
                    tmp=tmp.left;
                }
                tmp.left = node;
            }
            else
            {
                pre.right=cur.left;
            }
        }
        return test.val == key ? pre.right : root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
