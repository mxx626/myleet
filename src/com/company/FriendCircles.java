package com.company;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int count = 0;
        int[] visit = new int[n];
        for (int i=0; i<n; ++i){
            if (visit[i]==0){
                dfs(M, visit, i);
                count++;
            }
        }
        return count;
    }
    private void dfs (int[][] M, int[] visit, int i){
        for (int j=0; j<M.length; ++j){
            if (M[i][j]==1 && visit[j]==0){
                visit[j]=1;
                dfs(M, visit, j);
            }
        }
    }

    public int findCircleNum1(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
        for (int i=0; i<n; ++i){
            for (int j=0; j<i; ++j){
                if (M[i][j]==1){
                    if (uf.find(j)!=uf.find(i)){
                        uf.union(i, j);
                    }
                }
            }
        }
        return uf.count;
    }
    class UF{
        int[] root=null;
        int count = 0;
        public UF(int n){
            root = new int[n];
            count= n;
            for (int i=0; i<n; ++i){
                root[i] = i;
            }
        }
        public int find(int n){
            if(n==root[n])
                return n;
            root[n] = find(root[n]);
            return root[n];
        }
        public boolean union(int x, int y){
            int x_root = find(x);
            int y_root = find(y);
            if (x==y) return false;
            root[x_root]=y_root;
            count--;
            return true;
        }
    }
}
