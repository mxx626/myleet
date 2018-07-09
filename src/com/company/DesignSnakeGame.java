package com.company;

import java.util.*;

/**
 * 359 Design Snake Game
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

 Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 Example:
 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)

 */
public class DesignSnakeGame {
    private Queue<int[]> queue;
    private HashSet<String> set;
    private Map<String, int[]> map;
    private int[][] foods;
    private int[] cur;
    private int score;
    private int idx;
    private int width;
    private int height;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public DesignSnakeGame(int width, int height, int[][] food) {
        this.queue = new LinkedList<>();
        this.foods = food;
        this.map = new HashMap<>();
        this.set = new HashSet<>();
        this.cur = new int[]{0,0};
        this.score = 0;
        this.idx = 0;
        this.width = width;
        this.height = height;
        map.put("U", new int[]{-1, 0});
        map.put("D", new int[]{1, 0});
        map.put("L", new int[]{0, -1});
        map.put("R", new int[]{0, 1});
        queue.offer(new int[]{cur[0], cur[1]});
        int r = cur[0], c = cur[1];
        set.add(r+" "+c);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] dir = map.get(direction);
        int r = cur[0]+dir[0], c = cur[1]+dir[1];
        if (r<0 || r>height-1 || c<0 || c>width-1) return -1;
        if (set.contains(r+" "+c) && !(queue.peek()[0]==r && queue.peek()[1]==c)) return -1;
        cur[0]=r; cur[1]=c;
        if (idx<foods.length && r==foods[idx][0] && c==foods[idx][1]){
            if (r<height && c<width){
                queue.offer(new int[]{r, c});
                set.add(r+" "+c);
                score++;
                idx++;
            }
        }
        else if (r==queue.peek()[0] && c==queue.peek()[1]){
            queue.poll();
            queue.offer(new int[]{r,c});
        }
        else {
            int[] discard = queue.poll();
            int t = discard[0], k = discard[1];
            set.remove(t+" "+k);
            queue.offer(new int[]{r, c});
            set.add(r+" "+c);
        }
        return score;
    }
}
