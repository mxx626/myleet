package Stack;
// Stack
import java.util.Stack;
import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II
 *
 *
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element. The Next Greater Number of a number x is the
 * first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

 Example 1:
 Input: [1,2,1]
 Output: [2,-1,2]
 Explanation: The first 1's next greater number is 2;
 The number 2 can't find next greater number;
 The second 1's next greater number needs to search circularly, which is also 2.
 Note: The length of given array won't exceed 10000.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums==null || nums.length==0) return new int[0];
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (nums.length==1) return res;
        int idx = 2*nums.length-2;
        int len = nums.length;
        Stack<Integer> st = new Stack<>();

        for (int i=idx; i>=0; i--){
            int num = nums[i%len];
            if (st.isEmpty()) st.push(num);
            else if (num>=st.peek()) {
                while (!st.isEmpty() && st.peek()<=num) st.pop();
                if (!st.isEmpty()) res[i%len]=st.peek();
                st.push(num);
            }
            else if (num<st.peek()) {
                res[i%len]=st.peek();
                st.push(num);
            }
        }
        return res;
    }
}
