package String;
// TAG: String, DP
public class DecodeWays {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:

     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
     Given an encoded message containing digits, determine the total number of ways to decode it.

     For example,
     Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

     The number of ways decoding "12" is 2.
     */
    private int res=0;
    public int numDecodings(String s) {
        if (s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        int[] dp = new int[s.length()+1];
        char[] ch = s.toCharArray();
        dp[0]=1;
        dp[1]=1;
        for (int i=1; i<ch.length; ++i){
            if(ch[i]=='0') {
                if (ch[i-1]=='0' || ch[i-1]>'2') return 0;
                else dp[i+1]=dp[i-1];
            }
            else if (ch[i]>'6'){
                if (ch[i-1]>'0' && ch[i-1]<'2'){
                    dp[i+1]=dp[i-1]+dp[i];
                }
                else dp[i+1]=dp[i];
            }
            else if (ch[i]<='6'){
                if (ch[i-1]>'0' && ch[i-1]<'3'){
                    dp[i+1]=dp[i-1]+dp[i];
                }
                else dp[i+1]=dp[i];
            }
            //     System.out.println(dp[i+1]);
        }
        return dp[ch.length];
    }

    public int numDecodings2(String s) {
        if (s==null || s.length()==0) return 0;
        int[] dp = new int[s.length()+1];
        char[] ch = s.toCharArray();
        char prev='#', cur = '#';
        dp[0]=1;
        for (int i=0; i<ch.length; ++i){
            cur = ch[i];
            if (cur=='0'){
                if (prev!='1'&& prev!='2') return 0;
                else dp[i+1]=dp[i-1];
            }
            else {
                dp[i+1]=dp[i];
                if (prev=='1'|| (prev=='2' && cur>='1'&& cur<='6')){
                    dp[i+1] += dp[i-1];
                }
            }
            prev = cur;
        }
        return dp[ch.length];
    }
}
