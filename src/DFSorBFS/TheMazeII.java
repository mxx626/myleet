package DFSorBFS;
// BFS, Dijkstra, DFS
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

public class TheMazeII {
    private final static int[][] delta = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    /**
     * There is a ball in a maze with empty spaces and walls. The ball can go through empty
     * spaces by rolling up, down, left or right, but it won't stop rolling until hitting a
     * wall. When the ball stops, it could choose the next direction.

     Given the ball's start position, the destination and the maze, find the shortest distance
     for the ball to stop at the destination. The distance is defined by the number of empty
     spaces traveled by the ball from the start position (excluded) to the destination (included).
     If the ball cannot stop at the destination, return -1.

     The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
     You may assume that the borders of the maze are all walls. The start and destination coordinates
     are represented by row and column indexes.
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        int[][] visit = new int[row][col];
        int[][] dist = new int[row][col];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2]-b[2];
            }
        });
        visit[start[0]][start[1]]=1;
        dist[start[0]][start[1]]=0;
        queue.offer(new int[]{start[0], start[1], 0});
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int distance = dist[cur[0]][cur[1]];
            if (cur[0]==destination[0]&&cur[1]==destination[1]) {
                return distance;
            }

            for (int[] d : delta){
                int x = cur[0], y=cur[1];
                int tmp = 0;
                while (x+d[0]>=0 && y+d[1]>=0 && x+d[0]<row && y+d[1]<col && maze[x+d[0]][y+d[1]]==0){
                    x += d[0];
                    y += d[1];
                    tmp++;
                }
                if (visit[x][y]==0){
                    visit[x][y]=1;
                    queue.offer(new int[]{x,y,distance+tmp});
                }
                dist[x][y] = Math.min(dist[x][y], distance+tmp);
            }
        }
        return -1;
    }


    public int shortestDistance2(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        int[][] dist = new int[row][col];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[start[0]][start[1]]=0;
        dfs(maze, start, destination, dist);
        return dist[destination[0]][destination[1]]==Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
    private void dfs (int[][] maze, int[] start, int[] des, int[][] dist){
        int len = dist[start[0]][start[1]];
        for (int[] d : delta){
            int x  = start[0], y = start[1];
            int tmp = 0;
            while (x+d[0]>=0&&x+d[0]<maze.length&&y+d[1]>=0&&y+d[1]<maze[0].length&&maze[x+d[0]][y+d[1]]==0){
                x += d[0];
                y += d[1];
                tmp++;
            }
            if (len+tmp < dist[x][y]){
                dist[x][y]=len+tmp;
                dfs(maze, new int[]{x, y}, des, dist);
            }
        }
    }
}
