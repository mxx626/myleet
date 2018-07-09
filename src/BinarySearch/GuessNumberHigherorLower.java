package BinarySearch;
// Binary Search
public class GuessNumberHigherorLower {
    /**
     * We are playing the Guess Game. The game is as follows:

     I pick a number from 1 to n. You have to guess which number I picked.

     Every time you guess wrong, I'll tell you whether the number is higher or lower.

     You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

     -1 : My number is lower
     1 : My number is higher
     0 : Congrats! You got it!
     Example:
     n = 10, I pick 6.

     Return 6.

     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int start=1, end=n;
        while (start<end){
            int m = start+(end-start)/2;
            if (guess(m)==0) return m;
            else if (guess(m)==1) start=m+1;
            else if (guess(m)==-1) end=m;
        }
        return start;
    }
    int guess(int num){return 0;}
}
