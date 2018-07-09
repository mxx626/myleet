package BinarySearch;
// TAG: Binary Search
public class H_IndexII {
    /**
     * Follow up for H-Index: What if the citations array is sorted in ascending
     * order? Could you optimize your algorithm?
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0) return 0;
        int len = citations.length;
        int i=0, j=len-1;
        while (i<=j){
            int m = i+(j-i)/2;
            int num = citations[m];
            if (num >= len-m){
                j=m-1;
            }
            else i=m+1;
        }
        return len-i;
    }
}
