package Design;
// Design
public class MovingAveragefromDataStream {
    private int[] db=null;
    private int count=0;
    private int size=0;
    private int idx=0;
    private double sum=0;
    /**
     * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

     For example,
     MovingAverage m = new MovingAverage(3);
     m.next(1) = 1
     m.next(10) = (1 + 10) / 2
     m.next(3) = (1 + 10 + 3) / 3
     m.next(5) = (10 + 3 + 5) / 3
     */
    /** Initialize your data structure here. */
    public MovingAveragefromDataStream(int size) {
        this.db = new int[size];
        this.size=size;
    }

    public double next(int val) {
        int i = idx%size;
        sum = sum-db[i]+val;
        db[i]=val;
        idx++;
        count++;
        return sum / (count<size ? count : size);
    }
}
