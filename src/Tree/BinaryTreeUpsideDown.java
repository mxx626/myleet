package Tree;
// Tree
public class BinaryTreeUpsideDown {
    /**
     * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node
     * that shares the same parent node) or empty, flip it upside down and turn it into a tree where
     * the original right nodes turned into left leaf nodes. Return the new root.

     For example:
     Given a binary tree {1,2,3,4,5},

     1
     / \
     2   3
     / \
     4   5


     return the root of the binary tree [4,5,2,#,#,3,1].

     4
     / \
     5   2
     / \
     3   1


     confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


     OJ's Binary Tree Serialization:

     The serialization of a binary tree follows a level order traversal, where '#' signifies a path
     terminator where no node exists below.

     Here's an example:

     1
     / \
     2   3
     /
     4
     \
     5
     The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".


     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode preR=null, preL=null;
        TreeNode pre = null;
        while (cur!=null)
        {
            TreeNode res = cur.left; // Record next node;
            TreeNode L = cur.right; // Record next node's left and right
            TreeNode R = cur;
            cur.left = preL;   // give current node's left and right
            cur.right = preR;
            preL = L;
            preR = R;
            pre = cur;   // Recode the final recorded node
            cur = res;

        }
        return pre;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
