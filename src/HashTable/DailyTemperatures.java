package HashTable;
// TAG: HashTable, stack
public class DailyTemperatures {
    /**
     * Given a list of daily temperatures, produce a list that, for each
     * day in the input, tells you how many days you would have to wait
     * until a warmer temperature. If there is no future day for which this
     * is possible, put 0 instead.

     For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73],
     your output should be [1, 1, 4, 2, 1, 1, 0, 0].

     Note: The length of temperatures will be in the range [1, 30000]. Each
     temperature will be an integer in the range [30, 100].
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures==null || temperatures.length==0) return new int[0];
        int len = temperatures.length;
        int[] res = new int[len];
        int[] s = new int[len];
        int idx=0;
        s[idx]=len-1;
        for (int i=res.length-2; i>=0; --i){
            while (idx>=0 && temperatures[i]>=temperatures[s[idx]]){
                idx--;
            }
            if (idx>=0) res[i]=s[idx]-i;
            s[++idx]=i;
        }
        return res;
    }
}
