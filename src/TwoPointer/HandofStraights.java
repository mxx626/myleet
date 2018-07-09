package TwoPointer;
// Two Pointer
import java.util.Arrays;
public class HandofStraights {
    /**
     * Alice has a hand of cards, given as an array of integers.

     Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

     Return true if and only if she can.



     Example 1:

     Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
     Output: true
     Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
     Example 2:

     Input: hand = [1,2,3,4,5], W = 4
     Output: false
     Explanation: Alice's hand can't be rearranged into groups of 4.


     Note:

     1 <= hand.length <= 10000
     0 <= hand[i] <= 10^9
     1 <= W <= hand.length
     * @param hand
     * @param W
     * @return
     */
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand==null || hand.length==0) return true;
        if (hand.length % W!=0) return false;
        Arrays.sort(hand);
        for (int i=0; i<hand.length; ++i){
            if (hand[i]>=0){
                int min = hand[i];
                hand[i]=-hand[i]-1;
                int j=i+1;
                int k = W-1;
                while (k>0 && j<hand.length){
                    if ((hand[j]<0) || hand[j]==min) j++;
                    else if (hand[j]==min+1) {
                        min++;
                        hand[j]=-hand[j]-1;
                        j++;
                        k--;
                    }
                    else return false;
                }
                if (k!=0) return false;
            }
        }
        return true;
    }
}
