package DFS;
// DFS, BFS
import java.util.LinkedList;

public class WallsandGates {
    /**
     * You are given a m x n 2D grid initialized with these three possible values.

     -1 - A wall or an obstacle.
     0 - A gate.
     INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
     represent INF as you may assume that the distance to a gate is less than 2147483647.
     Fill each empty room with the distance to its nearest gate. If it is impossible
     to reach a gate, it should be filled with INF.

     For example, given the 2D grid:
     INF  -1  0  INF
     INF INF INF  -1
     INF  -1 INF  -1
     0  -1 INF INF
     After running your function, the 2D grid should be:
     3  -1   0   1
     2   2   1  -1
     1  -1   2  -1
     0  -1   3   4

     * @param rooms
     */
    public void wallsAndGates1(int[][] rooms) {
        if (rooms==null || rooms.length==0 || rooms[0].length==0) return;
        int row = rooms.length, col = rooms[0].length;
        for (int i=0; i<row; ++i){
            for (int j=0; j<col; ++j){
                if (rooms[i][j]==0) helper(rooms, i, j, 0);
            }
        }
    }
    private void helper(int[][] r, int x, int y, int d){
        if (x<0 || x>r.length-1 || y<0 || y>r[0].length-1 || r[x][y]<d) return;
        r[x][y]=d;
        helper(r, x-1, y, d+1);
        helper(r, x+1, y, d+1);
        helper(r, x, y-1, d+1);
        helper(r, x, y+1, d+1);
    }

    // BFS
    private final static int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if (rooms==null || rooms.length==0 || rooms[0].length==0) return;
        int row = rooms.length, col = rooms[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; ++i){
            for (int j=0; j<col; ++j){
                if (rooms[i][j]==0) queue.offer(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; ++i){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if (x>0 && rooms[x-1][y]==INF){
                    rooms[x-1][y] = rooms[x][y]+1;
                    queue.offer(new int[]{x-1, y});
                }
                if (x<row-1 && rooms[x+1][y]==INF){
                    rooms[x+1][y] = rooms[x][y]+1;
                    queue.offer(new int[]{x+1, y});
                }
                if (y>0 && rooms[x][y-1]==INF){
                    rooms[x][y-1] = rooms[x][y]+1;
                    queue.offer(new int[]{x, y-1});
                }
                if (y<col-1 && rooms[x][y+1]==INF){
                    rooms[x][y+1] = rooms[x][y]+1;
                    queue.offer(new int[]{x, y+1});
                }
            }
        }
    }
}
