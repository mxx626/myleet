package com.company;
// DFS
import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target

 Given a directed, acyclic graph of N nodes.  Find all possible paths from node
 0 to node N-1, and return them in any order.

 The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
 graph[i] is a list of all nodes j for which the edge (i, j) exists.

 Example:
 Input: [[1,2], [3], [3], []]
 Output: [[0,1,3],[0,2,3]]
 Explanation: The graph looks like this:
 0--->1
 |    |
 v    v
 2--->3
 There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 Note:

 The number of nodes in the graph will be in the range [2, 15].
 You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int len = graph.length;
        boolean[] visit = new boolean[len];
        visit[0]=true;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, visit, 0, len-1, res, list);
        return res;
    }
    private void dfs(int[][] graph, boolean[] visit, int s, int e, List<List<Integer>> res, List<Integer> list){
        if (s==e) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (graph[s].length==0) return;
        for (int next : graph[s]){
            if (!visit[next]){
                visit[next]=true;
                list.add(next);
                dfs(graph, visit, next, e, res, list);
                visit[next]=false;
                list.remove(list.size()-1);
            }
        }
    }
}
