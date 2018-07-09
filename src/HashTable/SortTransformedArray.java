package HashTable;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums==null || nums.length==0) return new int[0];
        int len = nums.length;
        int[] res = new int[len];
        int i=0, j=len-1;
        int idx = a>0 ? len-1 : 0;
        while (i<=j){
            if (a>0){
                res[idx--]=getQuadratic(a,b,c,nums[j])>getQuadratic(a,b,c,nums[i]) ? getQuadratic(a,b,c,nums[j--]) : getQuadratic(a,b,c,nums[i++]);
            }
            else {
                res[idx++]=getQuadratic(a,b,c,nums[j])>getQuadratic(a,b,c,nums[i]) ? getQuadratic(a,b,c,nums[i++]) : getQuadratic(a,b,c,nums[j--]);
            }
        }
        return res;
    }
    private int getQuadratic (int a, int b, int c, int x){
        return a*x*x+b*x+c;
    }
}
