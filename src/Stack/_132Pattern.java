package Stack;
// Stack
import java.util.Stack;

public class _132Pattern {
    /**
     * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai,
     * aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list
     * of n numbers as input and checks whether there is a 132 pattern in the list.

     Note: n will be less than 15,000.

     Example 1:
     Input: [1, 2, 3, 4]

     Output: False

     Explanation: There is no 132 pattern in the sequence.
     Example 2:
     Input: [3, 1, 4, 2]

     Output: True

     Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
     Example 3:
     Input: [-1, 3, 2, 0]

     Output: True

     Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int next = Integer.MIN_VALUE;
        for (int i=nums.length-1; i>=0; --i){
            if (s.isEmpty() || s.peek()>nums[i]){
                if (nums[i]<next) return true;
                s.push(nums[i]);
            }
            else if (s.peek()<nums[i]) {
                while (!s.isEmpty() && s.peek() < nums[i]) {
                    next = s.peek();
                    s.pop();
                }
                s.push(nums[i]);
            }
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1 || nums.length == 2) return false;
        Stack<Integer> stack = new Stack<>();
        int start=nums.length-1;
        stack.push(nums[start--]);
        int min2=Integer.MIN_VALUE;
        while (!stack.isEmpty() && start>=0){
            if (nums[start]<min2){
                return true;
            }
            if (nums[start]<=stack.peek()){
                stack.push(nums[start--]);
            }
            else if (nums[start]>stack.peek()){
                while (!stack.isEmpty() && stack.peek()<nums[start]){
                    min2=Math.max(min2, stack.pop());
                }
                stack.push(nums[start--]);
            }
        }
        return false;
    }
}
