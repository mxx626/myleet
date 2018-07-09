package String;
// String
public class ShiftingLetters {
    /**
     * We have a string S of lowercase letters, and an integer array shifts.

     Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

     For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

     Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

     Return the final string after all such shifts to S are applied.

     Example 1:

     Input: S = "abc", shifts = [3,5,9]
     Output: "rpl"
     Explanation:
     We start with "abc".
     After shifting the first 1 letters of S by 3, we have "dbc".
     After shifting the first 2 letters of S by 5, we have "igc".
     After shifting the first 3 letters of S by 9, we have "rpl", the answer.
     Note:

     1 <= S.length = shifts.length <= 20000
     0 <= shifts[i] <= 10 ^ 9
     * @param S
     * @param shifts
     * @return
     */
    public String shiftingLetters(String S, int[] shifts) {
        long[] count = new long[S.length()];
        long res = 0;
        for (int i=count.length-1; i>=0; --i){
            res += i<shifts.length ? shifts[i] : 0;
            count[i]=res;
        }
        if (shifts.length>count.length){
            for (int i=count.length; i<shifts.length; ++i){
                for (int j=0; j<count.length; ++j){
                    count[j] += shifts[i];
                }
            }
        }
        char[] ch = S.toCharArray();
        for (int i=0; i<ch.length; ++i){
            char tmp = (char)((ch[i]-'a'+count[i])%26+'a');
            ch[i]=tmp;
        }
        return new String(ch);
    }
}
