package Tree;
// Tree, Recursion, PreOrder
public class SerializeandDeserializeBST {
    /**
     * Serialization is the process of converting a data structure or object into a
     * sequence of bits so that it can be stored in a file or memory buffer, or
     * transmitted across a network connection link to be reconstructed later in the
     * same or another computer environment.

     Design an algorithm to serialize and deserialize a binary search tree. There is
     no restriction on how your serialization/deserialization algorithm should work.
     You just need to ensure that a binary search tree can be serialized to a string
     and this string can be deserialized to the original tree structure.

     The encoded string should be as compact as possible.

     Note: Do not use class member/global/static variables to store states. Your
     serialize and deserialize algorithms should be stateless.


     */
    private final static String NULLSTRING = "NULL";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return NULLSTRING;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",").append(serialize(root.left)).append(",").append(serialize(root.right));
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null || data.length()==0 || data.equals(NULLSTRING)) return null;
        String[] arr = data.split(",+");
        int[] val = {-1};
        return deser(arr, val);
    }
    private TreeNode deser (String[] arr, int[] idx)
    {
        idx[0]++;
        if (arr[idx[0]]==null || arr[idx[0]].length()==0 || arr[idx[0]].equals(NULLSTRING)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx[0]]));
        root.left = deser(arr, idx);
        root.right = deser(arr, idx);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left, right, next;
        TreeNode(int x) { val = x; }
    }
}
