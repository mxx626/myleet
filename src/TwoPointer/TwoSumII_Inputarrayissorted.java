package TwoPointer;
// Two Pointer
/**
 * 167. Two Sum II - Input array is sorted

 Given an array of integers that is already sorted in ascending order,
 find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that
 they add up to the target, where index1 must be less than index2.

 Note:

 Your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution and you may not use the same element twice.
 Example:

 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]
 Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumII_Inputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length<2) return new int[1];
        int s=0, e=numbers.length-1;
        int sum = numbers[s]+numbers[e];
        int[] res = new int[2];
        while (sum!=target){
            if (sum>target){
                sum = numbers[s]+numbers[--e];
            }
            else if (sum<target){
                sum = numbers[++s]+numbers[e];
            }
            else break;
        }
        res[0]=s+1;
        res[1]=e+1;
        return res;
    }
}
