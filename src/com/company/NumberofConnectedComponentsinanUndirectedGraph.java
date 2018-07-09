package com.company;
// DFS
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberofConnectedComponentsinanUndirectedGraph {
    List<List<Integer>> list = new ArrayList<>();

    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
     * (each edge is a pair of nodes), write a function to find the number
     * of connected components in an undirected graph.

     Example 1:
     0          3
     |          |
     1 --- 2    4
     Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

     Example 2:
     0           4
     |           |
     1 --- 2 --- 3
     Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

     Note:
     You can assume that no duplicate edges will appear in edges. Since all
     edges are undirected, [0, 1] is the same as [1, 0] and thus will not
     appear together in edges.
     * @param n
     * @param edges
     * @return
     */
    //DFS
    public int countComponents(int n, int[][] edges) {
        for (int i=0; i<n; ++i) list.add(new ArrayList<>());
        for (int[] e : edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        int[] visit = new int[n];
        int count = 0;
        for (int i=0; i<n; ++i){
            if (visit[i]==0){
                visit[i]=1;
                dfs(edges, visit, list.get(i));
                count++;
            }
        }
        return count;
    }
    private void dfs (int[][] edges, int[] visit, List<Integer> neighbor){
        for (int x : neighbor){
            if (visit[x]==0){
                visit[x]=1;
                dfs(edges, visit, list.get(x));
            }
        }
    }


    // UF
    public int countComponents2(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] e : edges){
            int x = uf.find(e[0]);
            int y = uf.find(e[1]);
            if (x!=y){
                uf.union(e[0], e[1]);
            }
        }
        return uf.getCount();
    }
    class UF{
        int[] root=null;
        int count=0;
        public UF(int n){
            root = new int[n];
            for (int i=0; i<n; ++i) root[i]=i;
            count=n;
        }

        private int find (int n){
            if (n==root[n]) return n;
            root[n] = find(root[n]);
            return root[n];
        }

        private void union(int x, int y){
            int x_root = find(x);
            int y_root = find(y);
            if (x_root==y_root) return;
            root[x_root] = find(y_root);
            count--;
        }
        private int getCount(){
            return this.count;
        }
    }

    //bfs
    public int countComponents3(int n, int[][] edges) {
        boolean[] visit = new boolean[n];
        int res = 0;
        for (int i=0; i<n; ++i){
            if (!visit[i]){
                bfs(edges, i, visit);
                res++;
            }
        }
        return res;
    }
    private void bfs(int[][] edges, int x, boolean[] visit){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(!q.isEmpty()){
            int k = q.poll();
            if (!visit[k]){
                for (int i=0; i<edges.length; ++i){
                    if (edges[i][0]==k) q.add(edges[i][1]);
                    if (edges[i][1]==k) q.add(edges[i][0]);
                }
            }
            visit[k]=true;
        }
    }
}
