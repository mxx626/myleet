package DFSorBFS;
// DFS, BFS
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    private int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};

    /**
     * There is a ball in a maze with empty spaces and walls. The ball can go through empty
     * spaces by rolling up, down, left or right, but it won't stop rolling until hitting a
     * wall. When the ball stops, it could choose the next direction.

     Given the ball's start position, the destination and the maze, determine whether the
     ball could stop at the destination.

     The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty
     space. You may assume that the borders of the maze are all walls. The start and destination
     oordinates are represented by row and column indexes.

     Example 1

     Input 1: a maze represented by a 2D array

     0 0 1 0 0
     0 0 0 0 0
     0 0 0 1 0
     1 1 0 1 1
     0 0 0 0 0

     Input 2: start coordinate (rowStart, colStart) = (0, 4)
     Input 3: destination coordinate (rowDest, colDest) = (4, 4)

     Output: true
     Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

     Example 2

     Input 1: a maze represented by a 2D array

     0 0 1 0 0
     0 0 0 0 0
     0 0 0 1 0
     1 1 0 1 1
     0 0 0 0 0

     Input 2: start coordinate (rowStart, colStart) = (0, 4)
     Input 3: destination coordinate (rowDest, colDest) = (3, 2)

     Output: false
     Explanation: There is no way for the ball to stop at the destination.

     Note:
     There is only one ball and one destination in the maze.
     Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
     The given maze does not contain border (like the red rectangle in the example pictures),
     but you could assume the border of the maze are all walls.
     The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        boolean[][] visit = new boolean[row][col];
        boolean res = dfs(maze, start[0], start[1], destination[0], destination[1], visit);
        return res;
    }
    private boolean dfs(int[][] maze, int i, int j, int tr, int tc, boolean[][] visit){
        if(i==tr && j==tc) return true;
        if (visit[i][j]) return false;
        visit[i][j]=true;
        for (int[] d : delta){
            int dx = i+d[0];
            int dy = j+d[1];
            while (dx>=0 && dy>=0 && dx<maze.length && dy<maze[0].length && maze[dx][dy]!=1){
                dx += d[0];
                dy += d[1];
            }
            dx -=d[0];
            dy -=d[1];
            if (!visit[dx][dy] && dfs(maze, dx, dy, tr, tc, visit)) return true;
        }
        return false;
    }


    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        boolean[][] visit = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        visit[start[0]][start[1]]=true;
        queue.offer(start);
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if (cur[0]==destination[0] && cur[1]==destination[1]) return true;
            for (int[] d : delta){
                int x=cur[0], y=cur[1];
                while (x>=0 && x<row && y>=0 && y<col && maze[x][y]==0){
                    x += d[0];
                    y += d[1];
                }
                x-=d[0];
                y-=d[1];
                if (!visit[x][y]){
                    visit[x][y]=true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }
}
