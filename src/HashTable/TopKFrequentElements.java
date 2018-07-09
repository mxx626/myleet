package HashTable;
// TAG: HashTable, Heap
import java.util.*;

public class TopKFrequentElements {
    /**
     * Given a non-empty array of integers, return the k most frequent elements.

     For example,
     Given [1,1,1,2,2,3] and k = 2, return [1,2].

     Note:
     You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for (int num : nums){
            if (min>num){
                min=num;
            }
            if (num>max){
                max=num;
            }
        }
        int[][] count = new int[max-min+1][2];
        for (int n : nums){
            count[n-min][0]=n;
            count[n-min][1]++;
        }
        Arrays.sort(count, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1]-o1[1];
            }
        });
        List<Integer> res = new LinkedList<>();
        int i=0;
        while (k>0){
            res.add(count[i++][0]);
            k--;
        }
        return res;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for (int num : nums){
            if (min>num){
                min=num;
            }
            if (num>max){
                max=num;
            }
        }
        int[] count = new int[max-min+1];
        for (int n : nums){
            count[n-min]++;
        }
        List<Integer>[] sort = new List[nums.length+1];
        for (int i=0; i<count.length; ++i){
            int idx = count[i];
            if (sort[idx]==null){
                sort[idx] = new ArrayList<>();
            }
            sort[idx].add(i+min);
        }
        List<Integer> res = new LinkedList<>();
        for (int i=sort.length-1; i>=0; --i){
            if (sort[i]!=null){
                for (int x : sort[i]){
                    res.add(x);
                    if (res.size()==k) return res;
                }
            }
        }

        return res;
    }
}
