package DFSorBFS;
// BFS, Topological
import java.util.*;

/**
 * 444. Sequence Reconstruction
 DescriptionHintsSubmissionsDiscussSolution
 Check whether the original sequence org can be uniquely reconstructed from the sequences in
 seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
 Reconstruction means building a shortest common supersequence of the sequences in seqs
 (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine
 whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

 Example 1:

 Input:
 org: [1,2,3], seqs: [[1,2],[1,3]]

 Output:
 false

 Explanation:
 [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a
 valid sequence that can be reconstructed.
 Example 2:

 Input:
 org: [1,2,3], seqs: [[1,2]]

 Output:
 false

 Explanation:
 The reconstructed sequence can only be [1,2].
 Example 3:

 Input:
 org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

 Output:
 true

 Explanation:
 The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 Example 4:

 Input:
 org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

 Output:
 true
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[n+1];
        for (List<Integer> seq : seqs){
            if (seq.size()==1){
                if (!map.containsKey(seq.get(0))){
                    map.put(seq.get(0), new HashSet<>());
                }
            }
            else {
                for (int i=0; i<seq.size(); ++i){
                    if (seq.get(i)<1 || seq.get(i)>n) return false;
                    if (i==0) continue;
                    int pre = seq.get(i-1);
                    int cur = seq.get(i);
                    if (!map.containsKey(pre)){
                        map.put(pre, new HashSet<>());
                    }
                    if (!map.containsKey(cur)){
                        map.put(cur, new HashSet<>());
                    }
                    if (map.get(pre).add(cur)){
                        indegree[cur]++;
                    }
                }
            }
        }
        if (org.length!=map.size()) return false;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<indegree.length; ++i){
            if (indegree[i]==0)
                queue.offer(i);
        }
        int index=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            if (size>1) return false;
            int curr = queue.poll();
            if (org[index++]!=curr) return false;
            for (int next : map.get(curr)){
                indegree[next]--;
                if (indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        return index==org.length;
    }
    public boolean sequenceReconstruction2(int[] org, List<List<Integer>> seqs) {
        int idx[] = new int[org.length + 1], pairs = org.length - 1;
        for (int i = 0; i < org.length; i++)
            idx[org[i]] = i;
        boolean seen[] = new boolean[org.length + 1], isEmpty = true;
        for (List<Integer> seq : seqs)
            for (int i = 0; i < seq.size(); i++) {
                isEmpty = false;
                int curr = seq.get(i);
                if (curr < 1 || curr > org.length)
                    return false;
                if (i == 0) continue;
                int prev = seq.get(i - 1);
                if (idx[prev] + 1 == idx[curr]) {
                    if (!seen[prev]) {
                        seen[prev] = true;
                        pairs--;
                    }
                } else if (idx[prev] >= idx[curr])
                    return false;
            }
        return pairs == 0 && !isEmpty;
    }
}
