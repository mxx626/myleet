package com.company;
// Graph
import java.util.*;

/**
 * 133. Clone Graph

 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        map.put(node, newHead);
        queue.offer(node);
        while (!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode next : cur.neighbors){
                if (!map.containsKey(next)){
                    map.put(next, new UndirectedGraphNode(next.label));
                    queue.offer(next);
                }
                map.get(cur).neighbors.add(map.get(next));
            }
        }
        return newHead;
    }



    class UndirectedGraphNode {
        int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}
