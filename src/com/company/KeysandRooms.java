package com.company;
// DFS, UF
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class KeysandRooms {
    /**
     * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

     Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

     Initially, all the rooms start locked (except for room 0).

     You can walk back and forth between rooms freely.

     Return true if and only if you can enter every room.

     Example 1:

     Input: [[1],[2],[3],[]]
     Output: true
     Explanation:
     We start in room 0, and pick up key 1.
     We then go to room 1, and pick up key 2.
     We then go to room 2, and pick up key 3.
     We then go to room 3.  Since we were able to go to every room, we return true.
     Example 2:

     Input: [[1,3],[3,0,1],[2],[0]]
     Output: false
     Explanation: We can't enter the room with number 2.
     Note:

     1 <= rooms.length <= 1000
     0 <= rooms[i].length <= 1000
     The number of keys in all rooms combined is at most 3000.

     * @param rooms
     * @return
     */
    // DFS
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>();
        Set<Integer> set = new HashSet<>();
        dfs.push(0);
        set.add(0);
        while (!dfs.isEmpty()){
            int cur = dfs.pop();
            for (int next : rooms.get(cur)){
                if (!set.contains(next)){
                    dfs.push(next);
                    set.add(next);
                }
            }
            if (set.size()==rooms.size()) return true;
        }
        return rooms.size()==set.size();
    }
    // UF
    class UF{
        private int[] parent;
        private int count=0;
        public UF(int n){
            this.parent = new int[n];
            this.count = n;
            for (int i=0; i<n; ++i) parent[i] = i;
        }
        public int find(int x){
            while (x!=parent[x]){
                x=parent[x];
            }
            return x;
        }
        public boolean union(int x, int y){
            int root_x = find(x);
            int root_y = find(y);
            if (root_x==root_y) return false;
            parent[root_y] = find(root_x);
            return true;
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        UF uf = new UF(size);
        for (int i=0; i<size; ++i){
            if (rooms.get(i)==null || rooms.get(i).size()==0) continue;
            for (int j : rooms.get(i)){
                if (uf.union(i, j)){
                    uf.count--;
                }
            }
        }
        return uf.count==1;
    }
}
