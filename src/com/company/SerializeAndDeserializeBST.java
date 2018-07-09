package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can
     * be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed
     * later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
     * serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can
     * be serialized to a string and this string can be deserialized to the original tree structure.
     *
     * The encoded string should be as compact as possible.
     * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize
     * algorithms should be stateless.
     * **/
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private static final String spliter = ",";
    private static final String NULL = "N";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    private void serialize (TreeNode root, StringBuilder sb){
        if (root==null) {
            sb.append(NULL+spliter);
            return;
        }
        sb.append(root.val+spliter);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] arr = data.split(spliter);
        queue.addAll(Arrays.asList(arr));
        TreeNode root = deserialization(queue);
        return root;
    }
    private TreeNode deserialization (Queue<String> queue){
        String cur = queue.poll();
        if (cur.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left=deserialization(queue);
        root.right=deserialization(queue);
        return root;
    }

}
