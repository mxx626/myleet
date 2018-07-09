package Backtracking;
// Backtracking
import java.util.LinkedList;

public class AdditiveNumber {
    /**
     * Additive number is a string whose digits can form additive sequence.

     A valid additive sequence should contain at least three numbers. Except
     for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

     Given a string containing only digits '0'-'9', write a function to determine
     if it's an additive number.

     Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

     Example 1:

     Input: "112358"
     Output: true
     Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
     1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     Example 2:

     Input: "199100199"
     Output: true
     Explanation: The additive sequence is: 1, 99, 100, 199.
     1 + 99 = 100, 99 + 100 = 199
     Follow up:
     How would you handle overflow for very large input integers?
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        if (num==null || num.length()<3) return false;
        LinkedList<Long> res = new LinkedList<>();
        return helper(num, res, 0);
    }
    private boolean helper(String s, LinkedList<Long> res, int start){
        if (start==s.length() && res.size()>2) return true;
        for (int i=start; i<s.length(); ++i){
            if (s.charAt(start)=='0' && i>start) break;
            if (i+1-start>19) break;
            long num = Long.parseLong(s.substring(start, i+1));
            if (res.size()<2){
                res.offer(num);
                if (helper(s, res, i+1)) return true;
                res.pollLast();
            }
            else if (res.get(res.size()-2)+res.get(res.size()-1)==num){
                res.offer(num);
                if (helper(s, res, i+1)) return true;
                res.pollLast();
            }
            else if (res.get(res.size()-2)+res.get(res.size()-1)<num) break;
        }
        return false;
    }
}
