package com.company;

// BFS
import java.util.*;

/**
 * 863. All Nodes Distance K in Binary Tree

 We are given a binary tree (with root node root), a target node, and an integer value `K`.

 Return a list of the values of all nodes that have a distance K from the target node.
 The answer can be returned in any order.



 Example 1:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 Output: [7,4,1]
 Explanation:
 The nodes that are a distance 2 from the target node (with value 5)
 have values 7, 4, and 1.

 Note that the inputs "root" and "target" are actually TreeNodes.
 The descriptions of the inputs above are just serializations of these objects.

 Note:

 The given tree is non-empty.
 Each node in the tree has unique values 0 <= node.val <= 500.
 The target node is a node in the tree.
 0 <= K <= 1000.
 */
public class AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Set<Integer> visit = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        helper(map, root, null);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target.val);
        visit.add(target.val);
        while (!queue.isEmpty() && K>0){
            int size = queue.size();
            K--;
            for (int i=0; i<size; ++i){
                int cur = queue.poll();
                for (int next : map.get(cur)){
                    if (visit.add(next)){
                        queue.offer(next);
                    }
                }
            }
        }
        if (queue.isEmpty()) return res;
        for (int i : queue) res.add(i);
        return res;
    }
    private void helper(Map<Integer, List<Integer>> map, TreeNode root, Integer pre){
        if (root==null) return;
        if (!map.containsKey(root.val)) map.put(root.val, new ArrayList<>());
        if (pre!=null) map.get(root.val).add(pre);
        if (root.left!=null) {
            map.get(root.val).add(root.left.val);
            helper(map, root.left, root.val);
        }
        if (root.right!=null) {
            map.get(root.val).add(root.right.val);
            helper(map, root.right, root.val);
        }
    }
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val=val;
        }
    }
}
