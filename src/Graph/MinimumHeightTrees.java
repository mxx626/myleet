package Graph;
// Graph, BFS
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
    /**
     * For a undirected graph with tree characteristics, we can choose any node as the root.
     * The result graph is then a rooted tree. Among all possible rooted trees, those with
     * minimum height are called minimum height trees (MHTs). Given such a graph, write a f
     * unction to find all the MHTs and return a list of their root labels.

     Format
     The graph contains n nodes which are labeled from 0 to n - 1. You will be given the
     number n and a list of undirected edges (each edge is a pair of labels).

     You can assume that no duplicate edges will appear in edges. Since all edges are
     undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

     Example 1 :

     Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

     0
     |
     1
     / \
     2   3

     Output: [1]
     Example 2 :

     Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
     \ | /
     3
     |
     4
     |
     5

     Output: [3, 4]
     Note:

     According to the definition of tree on Wikipedia: “a tree is an undirected graph in
     which any two vertices are connected by exactly one path. In other words, any connected
     graph without simple cycles is a tree.”
     The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<>();
        if (edges==null || edges.length==0) {
            ret.add(0);
            return ret;
        }
        List<List<Integer>> next = new ArrayList<>();
        for (int i=0; i<n; ++i) next.add(new ArrayList<>());
        int[] indegree = new int[n];
        for (int[] e : edges){
            next.get(e[0]).add(e[1]);
            next.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; ++i){
            if (indegree[i]==1)
                q.add(i);
        }
        while (!q.isEmpty()){
            int size = q.size();
            ret = new ArrayList<>();
            for (int i=0; i<size; ++i){
                int tmp = q.poll();
                ret.add(tmp);
                for (int x : next.get(tmp)){
                    indegree[x]--;
                    if (indegree[x]==1){
                        q.add(x);
                    }
                }
            }
        }
        return ret;
    }
}
