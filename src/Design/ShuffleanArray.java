package Design;
// Design
import java.util.Random;

/**
 *384. Shuffle an Array

 Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of
 [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 */
public class ShuffleanArray {
    int[] nums;
    Random rand;
    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums==null) return null;
        int[] arr = nums.clone();
        for (int i=1; i<nums.length; ++i){
            int pos = rand.nextInt(i+1);
            int tmp = arr[pos];
            arr[pos]= arr[i];
            arr[i]  = tmp;
        }
        return arr;
    }

}
