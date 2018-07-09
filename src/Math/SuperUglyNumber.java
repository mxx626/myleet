package Math;
//Math, DP, PQ
import java.util.Arrays;
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        int len = primes.length;
        int[] idx = new int[primes.length];
        int[] number = Arrays.copyOf(primes, primes.length);
        int[] dp = new int[n];
        dp[0]=1;
        for (int i=1; i<n; ++i){
            int tmp = getMin(primes);
            dp[i]=tmp;
            for (int j=0; j<primes.length; ++j){
                if (tmp==primes[j]){
                    idx[j]++;
                    primes[j]=dp[idx[j]]*number[j];
                }
            }
        }
        return dp[n-1];
    }
    public int getMin(int[] primes){
        int min = primes[0];
        for (int i : primes){
            if (i<min){
                min=i;
            }
        }
        return min;
    }
}
