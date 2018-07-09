package String;
// TAG: String
public class NextGreaterElementIII {
    /**
     * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer
     * which has exactly the same digits existing in the integer n and is greater in
     * value than n. If no such positive 32-bit integer exists, you need to return -1.

     Example 1:

     Input: 12
     Output: 21


     Example 2:

     Input: 21
     Output: -1
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        if (n<=10) return -1;
        char[] ch = String.valueOf(n).toCharArray();
        int start=0;
        for (char c : ch){
            if (c!='0') break;
            else start++;
        }
        int idx=start;
        for (int i=ch.length-1; i>start; --i){
            if (ch[i-1]<ch[i]) {
                idx=i;
                break;
            }
        }
        if (idx==start) return -1;
        for (int i=ch.length-1; i>=idx; --i){
            if (ch[i]>ch[idx-1]){
                char tmp = ch[i];
                ch[i]=ch[idx-1];
                ch[idx-1]=tmp;
                break;
            }
        }
        reverse(ch, idx, ch.length-1);
        long res = Long.valueOf(new String(ch).substring(start, ch.length));
        return res > Integer.MAX_VALUE ? -1 : (int)res;

    }
    private void reverse(char[] ch, int i, int j){
        while (i<j){
            char tmp = ch[i];
            ch[i]=ch[j];
            ch[j]=tmp;
            i++;
            j--;
        }
    }
}
