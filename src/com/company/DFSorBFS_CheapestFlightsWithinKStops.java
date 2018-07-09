package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DFSorBFS_CheapestFlightsWithinKStops {
    /**
     * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
     * Now given all the cities and fights, together with starting city src and the destination dst, your task
     * is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
     * Note:
     The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
     The size of flights will be in range [0, n * (n - 1) / 2].
     The format of each flight will be (src, dst, price).
     The price of each flight will be in the range [1, 10000].
     k is in the range of [0, n - 1].
     There will not be any duplicated flights or self cycles.

     * **/
    private int res=Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, List<int[]>> flight = new HashMap<>();
        for (int[] f : flights){
            if (!flight.containsKey(f[0])){
                flight.put(f[0], new ArrayList<>());
            }
            flight.get(f[0]).add(new int[]{f[1], f[2]});
        }
        DFS(src, dst, K, 0, flight, new int[n]);
        return res==Integer.MAX_VALUE ? -1 : res;
    }
    private void DFS (int src, int dst, int K, int price, HashMap<Integer, List<int[]>> flight, int[] visited){
        if (src == dst){
            res=Math.min(price, res);
        }
        else if (K>=0 && price < res){
            List<int[]> nextStop = flight.get(src);
            if (nextStop==null) return;
            for (int [] f : nextStop){
                if (f!=null && visited[f[0]]==0){
                    int next = f[0];
                    int trip = f[1];
                    visited[f[0]]=1;
                    DFS(next, dst, K-1, price+trip, flight, visited);
                    visited[f[0]]=0;
                }
            }
        }
    }
}
