package Tree;
// Tree
import java.util.*;

public class ClosestLeafinaBinaryTree {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    TreeNode start = null;

    /**
     * Given a binary tree where every node has a unique value, and a target key k,
     * find the value of the nearest leaf node to target k in the tree.

     Here, nearest to a leaf means the least number of edges travelled on the
     binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

     In the following examples, the input tree is represented in flattened
     form row by row. The actual root tree given will be a TreeNode object.

     Example 1:

     Input:
     root = [1, 3, 2], k = 1
     Diagram of binary tree:
     1
     / \
     3   2

     Output: 2 (or 3)

     Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
     Example 2:

     Input:
     root = [1], k = 1
     Output: 1

     Explanation: The nearest leaf node is the root node itself.
     Example 3:

     Input:
     root = [1,2,3,4,null,null,null,5,null,6], k = 2
     Diagram of binary tree:
     1
     / \
     2   3
     /
     4
     /
     5
     /
     6

     Output: 3
     Explanation: The leaf node with value 3 (and not the leaf node with
     value 6) is nearest to the node with value 2.
     Note:
     root represents a binary tree with at least 1 node and at most 1000 nodes.
     Every node has a unique node.val in range [1, 1000].
     There exists some node in the given binary tree for which node.val == k.
     * @param root
     * @param k
     * @return
     */
    public int findClosestLeaf(TreeNode root, int k) {
        buildGraph(root, null, k);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(start);
        Set<TreeNode> set = new HashSet<>();
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; ++i){
                TreeNode tmp = q.poll();
                set.add(tmp);
                if (tmp.left==null && tmp.right==null) return tmp.val;
                for (TreeNode next : map.get(tmp)){
                    if (set.contains(next))continue;
                    q.offer(next);
                }
            }
        }
        return -1;
    }
    private void buildGraph (TreeNode node, TreeNode parent, int k){
        if (node==null) return;
        if (node.val==k) start = node;
        if (parent!=null){
            if (!map.containsKey(node)){
                map.put(node, new ArrayList<>());
            }
            if (!map.containsKey(parent)){
                map.put(parent, new ArrayList<>());
            }
            map.get(node).add(parent);
            map.get(parent).add(node);
        }
        buildGraph(node.left, node, k);
        buildGraph(node.right, node, k);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
