package com.company;
// DFS
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FindEventualSafeStates {
    /**
     * In a directed graph, we start at some node and every turn, walk along a directed
     * edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing
     * directed edges), we stop.

     Now, say our starting node is eventually safe if and only if we must eventually walk
     to a terminal node.  More specifically, there exists a natural number K so that for
     any choice of where to walk, we must have stopped at a terminal node in less than K steps.

     Which nodes are eventually safe?  Return them as an array in sorted order.

     The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of
     graph.  The graph is given in the following form: graph[i] is a list of labels j such
     that (i, j) is a directed edge of the graph.

     Example:
     Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
     Output: [2,4,5,6]
     Here is a diagram of the above graph.

     Illustration of graph

     Note:

     graph will have length at most 10000.
     The number of edges in the graph will not exceed 32000.
     Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] state = new int[graph.length];
        for (int i=0; i<graph.length; ++i){
            if (dfs(graph, state, i)==2){
                res.add(i);
            }
        }
        return res;
    }
    private int dfs(int[][] graph, int[] state, int s){
        if (state[s]!=0) return state[s];
        if (graph[s]==null || graph[s].length==0) {
            state[s]=2;
            return state[s];
        }
        state[s]=1;
        for (int next : graph[s]){
            if (dfs(graph, state, next)==1)
                return 1;
        }
        state[s]=2;
        return state[s];
    }

    //
    private List<Integer> res;
    private enum state {unknown, visited, safe, unsafe}
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        res = new ArrayList<>();
        if (graph==null || graph.length==0) return res;
        state[] color = new state[graph.length];
        Arrays.fill(color, state.unknown);
        for (int i=0; i<graph.length; ++i){
            if (dfs(graph, color, i)==state.safe){
                res.add(i);
            }
        }
        return res;
    }
    private state dfs (int[][] graph, state[] color, int node){
        if (color[node] == state.visited){
            return state.unsafe;
        }
        else if (color[node]!=state.unknown){
            return color[node];
        }
        color[node]=state.visited;
        for (int neighbor : graph[node]){

            if (dfs(graph, color, neighbor)==state.unsafe){
                color[node]=state.unsafe;
                return color[node];
            }
        }
        color[node]=state.safe;
        return color[node];
    }
}
