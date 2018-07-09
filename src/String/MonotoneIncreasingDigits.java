package String;
// String
public class MonotoneIncreasingDigits {
    /**
     * Given a non-negative integer N, find the largest number that
     * is less than or equal to N with monotone increasing digits.

     (Recall that an integer has monotone increasing digits if and
     only if each pair of adjacent digits x and y satisfy x <= y.)

     Example 1:
     Input: N = 10
     Output: 9
     Example 2:
     Input: N = 1234
     Output: 1234
     Example 3:
     Input: N = 332
     Output: 299
     Note: N is an integer in the range [0, 10^9].
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        char[] ch = Integer.toString(N).toCharArray();
        int idx = ch.length;
        for (int i=ch.length-1; i>0; --i){
            if (ch[i]>=ch[i-1]) continue;
            --ch[i-1];
            idx=i;
        }
        for (int i=idx; i<ch.length; ++i){
            ch[i]='9';
        }
        return Integer.valueOf(new String(ch));
    }
}
