package Tree;
// TAG: Tree, Recuision
public class LowestCommonAncestorofaBinaryTree {
    private static boolean v1, v2;

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

     According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
     two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow
     a node to be a descendant of itself).”

     _______3______
     /              \
     ___5__          ___1__
     /      \        /      \
     6      _2       0       8
     /  \
     7   4
     For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of
     nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        v1=false; v2=false;
        if (root==p || root==q) return root;
        TreeNode res = helper(root, p, q);
        if (v1||v2) return res;
        return null;
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return null;
        if (root==q){
            v1=true;
            return root;
        }
        if (root==p){
            v2=true;
            return root;
        }
        TreeNode leftPre = helper(root.left, p, q);
        TreeNode rightPre = helper(root.right, p, q);
        if (leftPre!=null && rightPre!=null){
            return root;
        }
        return (leftPre!=null) ? leftPre : rightPre;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
