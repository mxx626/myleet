package TwoPointer;
// Two Pointer
/**
 * 777. Swap Adjacent in LR String

 In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
 a move consists of either replacing one occurrence of "XL" with "LX", or
 replacing one occurrence of "RX" with "XR". Given the starting string
 start and the ending string end, return True if and only if there exists
 a sequence of moves to transform one string to the other.

 Example:

 Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 Output: True
 Explanation:
 We can transform start to end following these steps:
 RXXLRXRXL ->
 XRXLRXRXL ->
 XRLXRXRXL ->
 XRLXXRRXL ->
 XRLXXRRLX
 Note:

 1 <= len(start) = len(end) <= 10000.
 Both start and end will only consist of characters in {'L', 'R', 'X'}.

 */
public class SwapAdjacentinLRString {
    public boolean canTransform(String start, String end) {
        int N = start.length();
        char[] S = start.toCharArray(), T = end.toCharArray();
        int i = -1, j = -1;
        while (++i < N && ++j < N) {
            while (i < N && S[i] == 'X') i++;
            while (j < N && T[j] == 'X') j++;

            if ((i < N) ^ (j < N)) return false;

            if (i < N && j < N) {
                if (S[i] != T[j] || (S[i] == 'L' && i < j) ||
                        (S[i] == 'R' && i > j) )
                    return false;
            }
        }
        return true;
    }
}
