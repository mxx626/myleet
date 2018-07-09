package HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root==null) return new int[0];
        helper(root);
        int max = Integer.MIN_VALUE, count=0;
        for (int c : map.values()){
            if (c>max) {
                max=c;
                count=1;
            }
            else if (c==max){
                count++;
            }
        }
        int[] res = new int[count];
        int idx=0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()){
            if (e.getValue()==max){
                res[idx++]=e.getKey();
            }
        }
        return res;
    }
    private int helper(TreeNode root){
        if (root==null) return 0;
        int sum=0;
        sum+=helper(root.left);
        sum+=helper(root.right);
        sum+=root.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        return sum;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

//////////////////////////Better///////////////////////////////
    private HashMap<Integer, Integer> map1 = new HashMap<>();
    private List<Integer> maxFreq = new LinkedList<>();
    private int max=-1;
    public int[] findFrequentTreeSum1(TreeNode root) {
        if (root==null) return new int[0];
        helper(root);
        int[] res = new int[maxFreq.size()];
        int idx=0;
        for (int i : maxFreq){
            res[idx++]=i;
        }
        return res;
    }
    private int helper1(TreeNode root){
        if (root==null) return 0;
        int sum=0;
        sum+=helper(root.left);
        sum+=helper(root.right);
        sum+=root.val;
        int freq = map1.getOrDefault(sum, 0)+1;
        map1.put(sum, freq);
        if (freq>max){
            maxFreq.clear();
            maxFreq.add(sum);
            max = freq;
        }
        else if (freq==max){
            maxFreq.add(sum);
        }
        return sum;
    }
}
