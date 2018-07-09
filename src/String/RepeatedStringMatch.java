package String;
// String
public class RepeatedStringMatch {
    /**
     * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

     For example, with A = "abcd" and B = "cdabcdab".

     Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

     Note:
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch(String A, String B) {
        if (A.equals(B) || A.indexOf(B)!=-1) return 1;
        if (!helper(A, B)) return -1;
        StringBuilder sb = new StringBuilder();
        int i=0;
        for (i=0; sb.length()<B.length(); ++i) sb.append(A);
        if (sb.indexOf(B)!=-1) return i;
        if (sb.append(A).indexOf(B)!=-1) return i+1;
        return -1;
    }
    private boolean helper(String A, String B){
        for (char c : B.toCharArray()){
            if (A.indexOf(c)==-1) return false;
        }
        return true;
    }
}
