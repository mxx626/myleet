package BinarySearch;
// Binary Search
public class Heaters {
    /**
     * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

     Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

     So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

     Note:
     Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
     Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
     As long as a house is in the heaters' warm radius range, it can be warmed.
     All the heaters follow your radius standard and the warm radius will the same.
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        quickSort(heaters, 0, heaters.length-1);
        int res = Integer.MIN_VALUE;
        for (int h : houses){
            int idx = binarySearch(heaters, h);
            int dist1 = idx==0 ? heaters[0]-h : h - heaters[idx-1];
            int dist2 = idx==heaters.length ? h-heaters[heaters.length-1] : heaters[idx]-h;
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }

    private int binarySearch (int[] heaters, int h){
        int i=0, j=heaters.length-1;
        while (i<=j){
            int m = i+(j-i)/2;
            if (heaters[m]==h) return m;
            else if (heaters[m]>h) j=m-1;
            else i=m+1;
        }
        return i;
    }

    private void quickSort(int[] nums, int start, int end){
        if (start>end) return;
        int idx = start-1;
        for (int i=start; i<end; ++i){
            if (nums[i]<=nums[end]){
                idx++;
                int tmp = nums[idx];
                nums[idx]=nums[i];
                nums[i]=tmp;
            }
        }
        int tmp = nums[++idx];
        nums[idx]=nums[end];
        nums[end]=tmp;
        quickSort(nums, start, idx-1);
        quickSort(nums, idx+1, end);
    }
}
