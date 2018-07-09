package Arrays;
// TAG: Arrays
public class PourWater {
    /**
     * We are given an elevation map, heights[i] representing the height of the terrain
     * at that index. The width at each index is 1. After V units of water fall at index
     * K, how much water is at each index?

     Water first drops at index K and rests on top of the highest terrain or water at that
     index. Then, it flows according to the following rules:

     If the droplet would eventually fall by moving left, then move left.
     Otherwise, if the droplet would eventually fall by moving right, then move right.
     Otherwise, rise at it's current position.
     Here, "eventually fall" means that the droplet will eventually be at a lower level if
     it moves in that direction. Also, "level" means the height of the terrain plus any water
     in that column.
     We can assume there's infinitely high terrain on the two sides out of bounds of the
     array. Also, there could not be partial water being spread out evenly on more than 1
     grid block - each unit of water has to be in exactly one block.

     heights will have length in [1, 100] and contain integers in [0, 99].
     V will be in range [0, 2000].
     K will be in range [0, heights.length - 1].

     * @param heights
     * @param V
     * @param K
     * @return
     */
    public int[] pourWater(int[] heights, int V, int K) {
        while (V-->0){
            dropWater(heights, K);
        }
        return heights;
    }
    private void dropWater(int[] heights, int K){
        int best = K;
        for (int i=-1; i<=1; i+=2){
            int d=K+i;
            while (d>=0 && d<heights.length && heights[d]<=heights[d-i]){
                if (heights[d]<heights[best]) best=d;
                d += i;
            }
            if (best!=K) break;
        }
        ++heights[best];
    }
}
