package UF;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// UF, DFS
public class GraphValidTree {
    private int[] parent = null;

    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a
     * pair of nodes), write a function to check whether these edges make up a valid tree.

     For example:

     Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

     Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

     Note: you can assume that no duplicate edges will appear in edges. Since all edges are
     undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree1(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; ++i) adj.add(new ArrayList<>());
        for (int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        boolean res = helper(adj, set, 0, -1);
        if (!res) return false;
        return set.size()==n;
    }
    private boolean helper(List<List<Integer>> list, Set<Integer> set, int node, int pre){
        List<Integer> succ = list.get(node);
        for (int next : succ){
            if (next==pre) continue;
            if (set.contains(next)) return false;
            set.add(next);
            boolean res = helper(list, set, next, node);
            if (!res) return false;
        }
        return true;
    }



    public boolean validTree(int n, int[][] edges) {
        if (edges.length!=n-1) return false;
        parent = new int[n];
        for (int i=0; i<n; ++i) parent[i]=i;
        for (int[] e : edges){
            int x = find(e[0]);
            int y = find(e[1]);
            if (x==y) return false;
            parent[x]=y;
        }
        return true;
    }
    private int find(int i){
        if (i==parent[i]) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }
}
