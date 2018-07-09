package Arrays;
// TAG: Array, Bucket Sort
public class MaximumSwap {
    /**
     * Given a non-negative integer, you could swap two digits at most once to get
     * the maximum valued number. Return the maximum valued number you could get.

     Example 1:
     Input: 2736
     Output: 7236
     Explanation: Swap the number 2 and the number 7.
     Example 2:
     Input: 9973
     Output: 9973
     Explanation: No swap.
     Note:
     The given number is in the range [0, 108]

     * @param num
     * @return
     */
    public int maximumSwap2(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        int[] bucket = new int[10];
        for (int i=0; i<ch.length; ++i){
            bucket[ch[i]-'0']=i;
        }
        for (int i=0; i<ch.length; ++i){
            for (int j=9; j>ch[i]-'0'; --j){
                if (bucket[j]<=i) continue;
                char tmp = ch[bucket[j]];
                ch[bucket[j]]=ch[i];
                ch[i]=tmp;
                return Integer.parseInt(new String(ch));
            }
        }
        return num;
    }
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] ch = str.toCharArray();
        int len=1, start=0, loc1=0, loc2=0;
        char c='0';
        while (start<ch.length-1){
            if (ch[start]>=ch[start+1]){
                len++;
                start++;
            }
            else break;
        }
        if (len==ch.length) return num;
        for (int i=ch.length-1; i>len-1; --i){
            if (ch[i]>c){
                c=str.charAt(i);
                loc2=i;
            }
        }
        for (int i=0; i<=len; ++i){
            if (c>ch[i]){
                loc1=i;
                break;
            }
        }
        char tmp = ch[loc2];
        ch[loc2] = ch[loc1];
        ch[loc1] = tmp;

        return Integer.parseInt(new String(ch));

    }


}
